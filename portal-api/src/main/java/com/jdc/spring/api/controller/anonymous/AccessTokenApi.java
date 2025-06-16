package com.jdc.spring.api.controller.anonymous;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.api.controller.anonymous.input.AccessTokenRequest;
import com.jdc.spring.api.controller.anonymous.output.AccessTokenResponse;
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
	
	@PostMapping("generate")
	public AccessTokenResponse generate(@Validated @RequestBody AccessTokenRequest req, BindingResult bindingResult) {
		var authentication = authenticationManager.authenticate(req.getAuthentication());
		return createResponse(req.username(), authentication);
		
	}
	
	@PostMapping("refresh")
	public AccessTokenResponse refresh(@Validated @RequestBody AccessTokenRequest req, BindingResult bindingResult) {
		var authentication = appTokenProvider.parseAccessToken(req.password());
		return createResponse(req.username(), authentication);
	}
	
	
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
