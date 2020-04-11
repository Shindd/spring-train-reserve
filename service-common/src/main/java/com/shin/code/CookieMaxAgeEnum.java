package com.shin.code;

/**
 * Maximum duration of cookies
 */
public enum CookieMaxAgeEnum {
	
	/** 30분 */
	HALF_HOUR(60 * 30),
	HOUR1(3600 * 1),
	HOUR2(3600 * 2),
	HOUR3(3600 * 3),
	HOUR4(3600 * 4),
	HOUR5(3600 * 5),
	HOUR6(3600 * 6),
	HOUR7(3600 * 7),
	HOUR8(3600 * 8),
	HOUR9(3600 * 9),
	HOUR10(3600 * 10),
	HOUR11(3600 * 11),
	HOUR12(3600 * 12),
	HOUR13(3600 * 13),
	HOUR14(3600 * 14),
	HOUR15(3600 * 15),
	HOUR16(3600 * 16),
	HOUR17(3600 * 17),
	HOUR18(3600 * 18),
	HOUR19(3600 * 19),
	HOUR20(3600 * 20),
	HOUR21(3600 * 21),
	HOUR22(3600 * 22),
	HOUR23(3600 * 23),
	HOUR24(3600 * 24),
	
	DAY1(86400 * 1),
	DAY2(86400 * 2),
	DAY3(86400 * 3),
	DAY4(86400 * 4),
	DAY5(86400 * 5),
	DAY6(86400 * 6),
	DAY7(86400 * 7),
	
	WEEK1(604800 * 1),
	WEEK2(604800 * 2),
	WEEK3(604800 * 3),
	WEEK4(604800 * 4),
	
	MONTH1(2592000 * 1),
	MONTH2(2592000 * 2),
	MONTH3(2592000 * 3),
	MONTH4(2592000 * 4),
	MONTH5(2592000 * 5),
	MONTH6(2592000 * 6),
	MONTH7(2592000 * 7),
	MONTH8(2592000 * 8),
	MONTH9(2592000 * 9),
	MONTH10(2592000 * 10),
	MONTH11(2592000 * 11),
	MONTH12(2592000 * 12),
	YEAR(31536000),
	UNLIMITED(-1);
	
	private int maxAge;
	
	private CookieMaxAgeEnum(int maxAge) {
		this.maxAge = maxAge;
	}
	
	public int getMaxAge() {
		return maxAge;
	}
}
