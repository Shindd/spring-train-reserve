package com.shin.domain;

/**
 * Adjust level of data lowered to json by API by API
 */
public class JsonViewSupport {
	
	// Contains always
	public interface Base {
	}
	
	// Summary data
	public interface Summary extends Base {
	}
	
	// Sub data
	public interface Sub extends Base {
	}
	
	// Detail data
	public interface Detail extends Summary {
	}
}
