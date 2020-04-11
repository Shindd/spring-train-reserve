package com.shin.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Read a message written in [message.properties]
 */
@Component
public class MessageUtils implements MessageSourceAware {
	
	private static MessageSource messageSource;
	
	@SuppressWarnings("static-access")
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public static String getMessage(String code) {
		return messageSource.getMessage(code, null, getLocale());
	}
	
	public static String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, getLocale());
	}
	
	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return messageSource.getMessage(code, args, defaultMessage, getLocale());
	}
	
	private static Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}
}
