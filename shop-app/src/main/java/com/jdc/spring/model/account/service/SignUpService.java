package com.jdc.spring.model.account.service;

import org.springframework.security.core.Authentication;

import com.jdc.spring.controller.input.SignUpForm;

public interface SignUpService {
	
	Authentication signUp(SignUpForm signUpForm);

}
