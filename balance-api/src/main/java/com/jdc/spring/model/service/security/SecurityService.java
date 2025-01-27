package com.jdc.spring.model.service.security;

import static com.jdc.spring.model.Commons.getOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.api.input.TokenRequest;
import com.jdc.spring.api.output.TokenResponse;
import com.jdc.spring.model.Status;
import com.jdc.spring.model.exceptions.ApiTokenInvalidException;
import com.jdc.spring.model.repo.AccountRepo;

@Service
@Transactional(readOnly = false)
public class SecurityService {
	
	private static final String ACCOUNT_DOMAIN = "Account";
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public TokenResponse generate(TokenRequest request) {
		var authentication = authenticationManager.authenticate(request.authenicationToken());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		var account = getOne(accountRepo.findOneByLoginId(request.loginId()), ACCOUNT_DOMAIN, request.loginId());
		var accessToken = tokenProvider.generateAccessToken(authentication);
		var refreshToken = tokenProvider.generateRefreshToken(authentication);
		
		var role = account.getRole().name();
		
		if(null != account.getEmployee() && account.getEmployee().getStatus() == Status.Applied) {
			role = account.getEmployee().getStatus().name();
		}
		return new TokenResponse(account.getName(), account.getLoginId(), role, accessToken, refreshToken);
	}
	
	public TokenResponse refresh(String token) {
		
		try {
			
			var authenication = tokenProvider.parse(token);
			SecurityContextHolder.getContext().setAuthentication(authenication);
			var account = getOne(accountRepo.findOneByLoginId(authenication.getName()), ACCOUNT_DOMAIN, authenication.getName());
			var accessToken = tokenProvider.generateAccessToken(authenication);
			var refreshToken = tokenProvider.generateRefreshToken(authenication);
			
			var role = account.getRole().name();
			
			if(null != account.getEmployee() && account.getEmployee().getStatus() == Status.Applied) {
				role = account.getEmployee().getStatus().name();
			}
			
			return new TokenResponse(account.getName(), account.getLoginId(), role, accessToken, refreshToken);
		} catch (Exception e) {
			throw new ApiTokenInvalidException("Your session has been timeout. Please login again.", e);
		}
	}

}
