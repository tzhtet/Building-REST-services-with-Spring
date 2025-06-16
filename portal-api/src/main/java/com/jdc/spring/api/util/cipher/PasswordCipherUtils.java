package com.jdc.spring.api.util.cipher;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

@Service
public class PasswordCipherUtils {
	
	private static PasswordSecret secret;
	
	public PasswordCipherUtils(PasswordSecret _secret) {
		secret = _secret;
	}
	
	public static String encrypt(String password) {
		try {
			
			var cipher = Cipher.getInstance("RSA");
			//cipher.init(Cipher.ENCRYPT_MODE, null);
			
		} catch (Exception e) {
		}
		return password;
	}

}
