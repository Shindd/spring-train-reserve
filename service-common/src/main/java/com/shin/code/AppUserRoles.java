package com.shin.code;

import lombok.Getter;

import com.shin.security.user.UserRoles;

@Getter
public enum AppUserRoles implements UserRoles {
	
	USER("USER"),
	LOGIN_USER("LOGIN_USER"),
	ADMIN("ADMIN");
	
	private String roleName;
	
	AppUserRoles(String roleName) {
		this.roleName = roleName;
	}
	
	public static AppUserRoles from(String roleName) {
		if (roleName != null) {
			switch (roleName.toUpperCase()) {
				case "USER":
					return USER;
				case "LOGIN_USER":
					return LOGIN_USER;
				case "ADMIN":
					return ADMIN;
			}
		}
		
		return USER;
	}
}
