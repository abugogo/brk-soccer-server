package com.soccer.http.cookie;

import java.io.Console;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CookieGen {
	
	public final static String DELIMITER = "|";
	public static void main(String[] args) {

		char[] passwordChar = new char[6];
		Console console = System.console();
		MessageDigest md = null;
		String encodedSetPwdInHexString = "5:BA:A6:1E:4C:9B:93:F3:F0:68:22:50:B6:CF:83:31:B7:EE:68:FD:8";

		// digest value of the string – password. change it to your required
		// password digest.

		try {

			md = MessageDigest.getInstance("SHA1"); // can be replaced with MD5
			// SHA1 has fewer collisions in comparison with MD5.

		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		try {
			passwordChar = console.readPassword("Enter Password : ");
		} catch (NullPointerException e) {
			System.out
					.println("You Might Be Running The Program From An IDE , Try In Terminal");
			passwordChar = new char[8];
			System.arraycopy(new char[] { 'p', 'a', 's', 's', 'w', 'o', 'r',
					'd' }, 0, passwordChar, 0, 8);
		}

		String passwordString = new String(passwordChar);
		byte[] passwordByte = passwordString.getBytes();

		md.update(passwordByte, 0, passwordByte.length);
		byte[] encodedPassword = md.digest(); // compute the digest
		String encodedPasswordInString = toHexString(encodedPassword);
		System.out
				.println("\nThe SHA1 digest of the password you entered in hex \n"
						+ encodedPasswordInString);

		// copy and paste this output to encodedSetPwdInHexString variable so
		// your required password is set.

		System.out
				.println("\nThe SHA1 digest of the Correct Password in hex \n "
						+ encodedSetPwdInHexString);

		if (encodedPasswordInString.equals(encodedSetPwdInHexString)) // compare
																		// both
		{
			System.out.println("Correct Password");
			System.exit(3);
		}
		System.out.println("Worng password");
		System.exit(2);

	}

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
