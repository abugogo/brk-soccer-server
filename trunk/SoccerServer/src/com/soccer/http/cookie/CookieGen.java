package com.soccer.http.cookie;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CookieGen {
	
	public final static String DELIMITER = "|";

	public static String generateCookieForUser(String user,
			String expiration, String pwd, String salt) {
		String c = user.concat(DELIMITER).concat(expiration);
		String encDigest = encodeString(pwd.concat(expiration).concat(salt)); 
		return c.concat(DELIMITER).concat(encDigest);
	}

	public static String encodeString(String str) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		byte[] encByte = str.getBytes();

		md.update(encByte, 0, encByte.length);
		byte[] digest = md.digest(); 
		String encDigest = toHexString(digest);
		
		return encDigest;

	}

	// method converts Byte Array To a HEX-String
	public static String toHexString(byte[] buf) {
		char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		StringBuffer strBuf = new StringBuffer(buf.length * 2);
		for (int i = 0; i < buf.length; i++) {
			strBuf.append(hexChar[(buf[i] & 0xf0) >>> 4]); // fill left with
			// zero bits
			strBuf.append(':');
			strBuf.append(hexChar[buf[i] & 0x0f]);
		}
		return strBuf.toString();
	}
}
