package com.shin.security.user;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * Instances of this class implementer are created through {@link UserFactory}
 */
@JsonIgnoreType
public abstract class GrantedUser {
	
	@JsonIgnore
	private Set<UserRoles> userRoles = new HashSet<>();
	
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}
	
	public void addRole(UserRoles userRole) {
		userRoles.add(userRole);
	}
	
	public boolean hasRole(UserRoles userRole) {
		return userRoles.contains(userRole);
	}
	
	public void clearRoles() {
		userRoles.clear();
	}
	
	public boolean isLogin() {
		return true;
	}
}
