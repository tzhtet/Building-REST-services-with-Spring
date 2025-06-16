package com.jdc.spring.api.util.cipher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordSecret {
	
	@Value("${private.key.change.password}")
	private String privateKey;
	@Value("${public.key.change.password}")
	private String publicKey;
	
	private String getPrivateKey() {
		return privateKey;
	}
	
	private String getPublicKey() {
		return publicKey;
	}

}
