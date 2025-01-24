package com.jdc.spring.model.service.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppAuthenicationProvider extends DaoAuthenticationProvider {
	
	public AppAuthenicationProvider(PasswordEncoder passwordEncoder, AppUserDetailsService userDetailsService) {
		super(passwordEncoder);
		setUserDetailsService(userDetailsService);
		setHideUserNotFoundExceptions(false);
	}
 

}
