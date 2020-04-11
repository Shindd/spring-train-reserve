package com.shin.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {
	
	private static final String FULL_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat(FULL_DATE_FORMAT_PATTERN);
	
	public static SimpleDateFormat getFullDateFormat() {
		return FULL_DATE_FORMAT;
	}
	
	public static String getCurrentDateString() {
		return DateFormatUtils.format(Calendar.getInstance(), FULL_DATE_FORMAT_PATTERN);
	}
}
