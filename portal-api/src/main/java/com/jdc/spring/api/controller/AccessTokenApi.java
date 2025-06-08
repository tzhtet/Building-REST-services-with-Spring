package com.jdc.spring.api.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.api.controller.output.AccessTokenResponse;
import com.jdc.spring.api.model.repo.AccountRepo;
import com.jdc.spring.api.util.security.AppTokenProvider;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("anonymous/token")
@RequiredArgsConstructor
public class AccessTokenApi {
	
	private final AuthenticationManager authenticationManager;
	private final AppTokenProvider appTokenProvider;
	private final AccountRepo accountRepo;
	
	//AccessTokenResponse generate()
	
	
	private AccessTokenResponse createResponse(String username,Authentication authentication) {
		var accessToken = appTokenProvider.generateAccessToken(authentication);
		var refreshToken = appTokenProvider.generateAccessToken(authentication);
		var role = authentication.getAuthorities().stream()
				.map(a -> a.getAuthority()).findAny().orElse("ROLE_ANONYMOUS");
		
		var account = accountRepo.findById(username)
				.orElseThrow();
		
		var name = switch(account.getRole()) {
		case Admin -> "Admin user";
		case Employee -> account.getEmployee().getName();
		case Student -> account.getStudent().getName();
		};
		return new AccessTokenResponse(name, role, accessToken, refreshToken);
		
	}
}
