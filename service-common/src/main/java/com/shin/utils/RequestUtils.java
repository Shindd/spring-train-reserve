package com.shin.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtils {
	
	private static final String[] IP_HEADER_KEYS = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
	private static final String CHARSET = "UTF-8";
	
	public static HttpServletRequest getCurrentRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		return request;
	}
	
	public static String getHeader(String name) {
		return getCurrentRequest().getHeader(name);
	}
	
	public static String getMethod() {
		return getCurrentRequest().getMethod();
	}
	
	public static String getRequestFullBaseURI() {
		String uri = buildRequestUrl(getCurrentRequest());
		try {
			uri = URLEncoder.encode(uri, CHARSET);
		} catch (UnsupportedEncodingException uee) {
		}
		return uri;
	}
	
	public static String getRequestFullURI() {
		String uri = buildFullRequestUrl(getCurrentRequest(), false);
		try {
			uri = URLEncoder.encode(uri, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
		}
		return uri;
	}
	
	public static String getRequestURI() {
		return getCurrentRequest().getRequestURI();
	}
	
	public static String getRemoteAddr(HttpServletRequest request) {
		for (String key : IP_HEADER_KEYS) {
			String ip = request.getHeader(key);
			
			if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
				int pos = ip.indexOf(',');
				return pos > 0 ? ip.substring(0, pos) : ip;
			}
		}
		
		return request.getRemoteAddr();
	}
	
	private static String buildFullRequestUrl(HttpServletRequest request, boolean isBase) {
		String scheme = request.getScheme().toLowerCase();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		
		StringBuilder url = new StringBuilder();
		url.append(scheme).append("://").append(serverName);
		
		// Only add port if not default
		if ("http".equals(scheme)) {
			if (serverPort != 80 && !isBase) {
				url.append(":").append(serverPort);
			}
		} else if ("https".equals(scheme)) {
			if (serverPort != 443 && !isBase) {
				url.append(":").append(serverPort);
			}
		}
		url.append(requestURI);
		if (queryString != null) {
			url.append("?").append(queryString);
		}
		
		return url.toString();
	}
	
	private static String buildRequestUrl(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		
		StringBuilder builder = new StringBuilder();
		builder.append(requestURI);
		if (queryString != null) {
			builder.append("?").append(queryString);
		}
		
		return builder.toString();
	}
}
