package com.jdc.spring.model.account.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.controller.input.SignUpForm;
import com.jdc.spring.model.account.entity.Account;
import com.jdc.spring.model.account.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements SignUpService{
	
	private final PasswordEncoder passwordEncoder;
	private final AccountRepo accountRepo;
	
	@Transactional
	@Override
	public Authentication signUp(SignUpForm signUpForm) {
		var account = new Account();
		account.setEmail(signUpForm.getEmail());
		account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
		return null;
	}

}
