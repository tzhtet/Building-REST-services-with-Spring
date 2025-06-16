package com.jdc.spring.api.util.cipher;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeysGenerator {
	
	private static void generate() throws NoSuchAlgorithmException {
		var generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048);
		
		var keypair = generator.generateKeyPair();
		
		var	publicKey = Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded());
		var	privateKey = Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded());
		
		System.out.println(publicKey);
		System.out.println(privateKey);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		generate();
	}

}
