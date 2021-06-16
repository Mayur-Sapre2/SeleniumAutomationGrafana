package com.selenium.utils;

import java.util.Base64;

public final class DeocdeUtils {

	private DeocdeUtils() {
		
	}
	
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
}
