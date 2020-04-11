package com.shin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.shin")
public class MainApplication {
	static {
		java.security.Security.setProperty("networkaddress.cache.ttl", "30");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
