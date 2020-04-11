package com.shin.utils;

import java.text.ParseException;
import java.util.Calendar;

import com.shin.domain.user.AppUser;

public class AuthTokenUtils {
	
	/**
	 * Validate auth token
	 * 1. Check login id
	 * 2. Check when this token created
	 *
	 * @param authToken
	 * @param loginId
	 * @return
	 */
	public static boolean validateAuthToken(String[] authToken, String loginId) {
		boolean validate = false;
		
		if (authToken != null && loginId != null && loginId.equals(authToken[0])) {
			Calendar cookieDate = Calendar.getInstance();
			try {
				cookieDate.setTime(DateUtils.getFullDateFormat().parse(authToken[1]));
			} catch (ParseException e) {
				return false;
			}
			cookieDate.add(Calendar.MINUTE, 30);
			if (!cookieDate.before(Calendar.getInstance())) {
				validate = true;
			}
		}
		
		return validate;
	}
	
	/**
	 * Generate user auth token
	 *
	 * @param appUser
	 * @return loginId | createdAt
	 */
	public static String generateAuthToken(AppUser appUser) {
		return appUser.getLoginId() + "|" + DateUtils.getCurrentDateString();
	}
}
