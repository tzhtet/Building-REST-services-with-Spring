package com.jdc.spring.api.util.security;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class AppTokenProvider {
	
	public enum Type{
		Access,Refresh
	}
	
	private String issuer;
	
	private int accessLife;
	
	private int refreshLife;
	
	
	private static final String roleKey = "rol";
	
	private static SecretKey secretKey = Jwts.SIG.HS512.key().build();
	
	public Authentication parseAccessToken(String token) {
		return parse(Type.Access, token);
	}

	private Authentication parse(Type type, String token) {
		
		var jwt = Jwts.parser()
				.requireIssuer(token);
		return null;
	}
	
	

}
