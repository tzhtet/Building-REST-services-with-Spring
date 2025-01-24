package com.jdc.spring.model.service.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {

	private static final String ROLE = "rol";
	
	@Value("${app.token.prefix}")
	private String prefix;
	
	@Value("${app.token.issuer}")
	private String issuer;
	
	@Value("${app.token.expiration.access")
	private int accessExpiration;
	
	@Value("${app.token.expiration.refresh}")
	private int refreshExpiration;
	
	@Value("${app.token.secret")
	private String secret;
	
	private SecretKey secretKey;
	
	@PostConstruct
	private void postConstruct() {
		secretKey = SecretKeys.toKey(secret);
	}
}
