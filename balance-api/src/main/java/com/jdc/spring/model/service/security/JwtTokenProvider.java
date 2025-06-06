package com.jdc.spring.model.service.security;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {
	
	private static final String ROLE = "rol";
	
	@Value("${app.token.prefix}")
	private String prefix;
	
	@Value("${app.token.issuer}")
	private String issuer;
	
	@Value("${app.token.expiration.access}")
	private int accessExpiration;
	
	@Value("${app.token.expiration.refresh}")
	private int refreshExpiration;
	
	@Value("${app.token.secret}")
	private String secret;
	
	private SecretKey secretKey;  
	
	@PostConstruct
	private void postConstruct() {
		secretKey = SecretKeys.toKey(secret);
	}
	
	public String generateAccessToken(Authentication authentication) {
		return generate(authentication, accessExpiration); 
	}
	
	public String generateRefreshToken(Authentication authentication) {
		return generate(authentication, refreshExpiration);
	}
	
	private String generate(Authentication authentication, int expiration) {
		
		var issueAt = new Date();
		var expireAt = Calendar.getInstance();
		expireAt.setTime(issueAt);
		expireAt.add(Calendar.MINUTE, expiration);
		
		var authorities = authentication.getAuthorities()
				.stream().map(a -> a.getAuthority())
				.collect(Collectors.joining(","));
		
		var token = Jwts.builder()
				.signWith(secretKey)
				.issuer(issuer)
				.issuedAt(issueAt)
				.expiration(expireAt.getTime())
				.subject(authentication.getName())
				.claim(ROLE, authorities)
				.compact();
		return "%s%s".formatted(prefix, token);
	}
	
	public Authentication parse(String token) {
		var payload = Jwts.parser()
				.requireIssuer(issuer)
				.verifyWith(secretKey)
				.build().parseSignedClaims(token.substring(prefix.length())).getPayload();
		
		var username = payload.getSubject();
		var roles = payload.get(ROLE,String.class);
		
		var authorities = Arrays.stream(roles.split(","))
				.map(a -> new SimpleGrantedAuthority(a)).toList();
		return UsernamePasswordAuthenticationToken.authenticated(username, null, authorities);
	}

}
