package com.shin.security.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import com.shin.code.CookieMaxAgeEnum;
import com.shin.domain.user.AppUser;
import com.shin.code.AppUserRoles;
import com.shin.service.UserAuthService;
import com.shin.utils.AuthTokenUtils;
import com.shin.utils.CookieUtils;

@Slf4j
@Component
public class UserFactoryImpl implements UserFactory {
	
	@Value("${app.security.cookie.auth:null}")
	private String authCookie;
	
	@Autowired
	private UserAuthService userAuthService;
	
	private static final String LOGIN_STATS = "LOGIN_STATS";
	
	// FIXME
	public GrantedUser getUser(HttpServletRequest request, HttpServletResponse response, Object handler) {
		AppUser appUser = new AppUser();
		setUserStatusFromHeader(request, appUser);
		
		String[] authToken = getAuthToken();
		if (AuthTokenUtils.validateAuthToken(authToken, appUser.getLoginId())) {
			AppUser userData = userAuthService.selectUser(appUser.getLoginId());
			if (userData != null) {
				appUser.setUserSeq(userData.getUserSeq());
				appUser.addRole(AppUserRoles.LOGIN_USER);
				userAuthService.updateLastAccessedAt(appUser.getUserSeq());
			}
			// TODO: insert [unauthorized user`s ip, accessed at] data
			CookieUtils.setCookie(response, authCookie, AuthTokenUtils.generateAuthToken(appUser), CookieMaxAgeEnum.UNLIMITED);
		}
		
		return appUser;
	}
	
	private void setUserStatusFromHeader(HttpServletRequest request, AppUser user) {
		String loginStats = request.getHeader(LOGIN_STATS);
		if (StringUtils.startsWithIgnoreCase(loginStats, "success")) {
			user.addRole(AppUserRoles.LOGIN_USER);
		}
	}
	
	private String[] getAuthToken() {
		String authToken = CookieUtils.getCookie(authCookie, true);
		if (StringUtils.isNotBlank(authToken)) {
			return authToken.split("\\|");
		}
		return null;
	}
}
