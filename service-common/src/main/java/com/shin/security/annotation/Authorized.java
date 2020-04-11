package com.shin.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.shin.code.AppUserRoles;
import com.shin.security.user.GrantedUser;

/**
 * Use this Annotation to specify the role granted to {@link GrantedUser} in the Controller.
 * If the user does not have the specified privilege in this annotation, the method will not be called.
 * If this annotation exists in a Type and does not exist in a method, the default value will be used,
 * If both types and methods exist, the values in the method will be prioritized.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Authorized {
	
	AppUserRoles[] value() default AppUserRoles.LOGIN_USER;
	
	String name() default "";
}
