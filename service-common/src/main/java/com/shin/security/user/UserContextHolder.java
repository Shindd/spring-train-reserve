package com.shin.security.user;

/**
 * Class that stores user objects created by {@link UserFactory} using ThreadLocal.
 */
public class UserContextHolder {
	
	private static ThreadLocal<GrantedUser> userThreadLocal = new ThreadLocal<>();
	
	public static void set(GrantedUser user) {
		userThreadLocal.set(user);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends GrantedUser> T get() {
		return (T) userThreadLocal.get();
	}
	
	public static void remove() {
		userThreadLocal.remove();
	}
}
