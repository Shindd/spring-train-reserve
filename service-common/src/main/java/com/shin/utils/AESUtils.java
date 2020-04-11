package com.shin.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	
	public static final String ALGORITHM = "AES";
	public static final String CHARSET = "UTF-8";
	public static final int RADIX = 16;
	
	public static String encrypt(String secretKey, String value) {
		if (value == null) {
			return null;
		}
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encrypted = cipher.doFinal(value.getBytes(CHARSET));
			return byteArrayToHex(encrypted);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String decrypt(String secretKey, String value) {
		if (value == null) {
			return value;
		}
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] origin = cipher.doFinal(hexToByteArray(value));
			return new String(origin, CHARSET);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] hexToByteArray(String hexValue) {
		if (hexValue == null || hexValue.length() == 0) {
			return null;
		}
		
		byte[] byteArray = new byte[hexValue.length() / 2];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte) Integer.parseInt(hexValue.substring(2 * i, 2 * i + 2), RADIX);
		}
		
		return byteArray;
	}
	
	public static String byteArrayToHex(byte[] byteArray) {
		if (byteArray == null || byteArray.length == 0) {
			return null;
		}
		
		StringBuilder builder = new StringBuilder(byteArray.length * 2);
		String hexNumber;
		for (byte element : byteArray) {
			hexNumber = "0" + Integer.toHexString(0xff & element);
			builder.append(hexNumber.substring(hexNumber.length() - 2));
		}
		
		return builder.toString();
	}
}
