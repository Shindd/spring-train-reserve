package com.shin.domain.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.shin.code.AppUserRoles;
import com.shin.security.user.GrantedUser;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AppUser extends GrantedUser {
	
	private Long userSeq;
	
	private String name;
	
	private String loginId;
	
	private String password;
	
	private Boolean isGranted;
	
	@Override
	public boolean isLogin() {
		return hasRole(AppUserRoles.LOGIN_USER);
	}
	
	public AppUser() {
		super();
	}
	
	public AppUser convertToAppUser() {
		AppUser appUser = new AppUser();
		appUser.setLoginId(this.loginId);
		return appUser;
	}
}
