package com.shin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.CookieGenerator;

import com.shin.code.CookieMaxAgeEnum;

@Component
public class CookieUtils {
	
	private static String cookieDomain;
	
	private static String secretKey;
	
	@Value("${app.security.cookie.domain:null}")
	private void setCookieDomain(String cookieDomain) {
		this.cookieDomain = cookieDomain;
	}
	
	@Value("${app.security.cookie.secret-key:null")
	private void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value, CookieMaxAgeEnum cookieMaxAgeEnum) {
		setCookie(response, name, value, cookieMaxAgeEnum.getMaxAge());
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName(name);
		cookieGenerator.setCookieMaxAge(maxAge);
		if (StringUtils.hasText(cookieDomain)) {
			cookieGenerator.setCookieDomain(cookieDomain);
		}
		cookieGenerator.addCookie(response, AESUtils.encrypt(secretKey, value));
	}
	
	public static void expireCookie(HttpServletResponse response, String name) {
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName(name);
		cookieGenerator.setCookieMaxAge(0);
		if (StringUtils.hasText(cookieDomain)) {
			cookieGenerator.setCookieDomain(cookieDomain);
		}
		cookieGenerator.addCookie(response, "");
	}
	
	public static String getCookie(String name) {
		return getCookie(name, false);
	}
	
	public static String getCookie(String name, boolean decrypt) {
		if (!StringUtils.hasText(name)) {
			return null;
		}
		
		Cookie[] cookies = RequestUtils.getCurrentRequest().getCookies();
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				if (decrypt) {
					return AESUtils.decrypt(secretKey, cookie.getValue());
				} else {
					return cookie.getValue();
				}
			}
		}
		
		return null;
	}
	
	public static String popCookie(String name, boolean decrypt, HttpServletResponse response) {
		String value = getCookie(name, decrypt);
		if (response != null && !response.isCommitted()) {
			setCookie(response, name, null, 0);
		}
		return value;
	}
}
