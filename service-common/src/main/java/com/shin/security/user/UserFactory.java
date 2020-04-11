package com.shin.security.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create user
 */
public interface UserFactory {
	
	GrantedUser getUser(HttpServletRequest request, HttpServletResponse response, Object handler);
}
