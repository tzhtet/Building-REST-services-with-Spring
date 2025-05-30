package com.jdc.spring.model.account.service;

import java.time.LocalDateTime;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.controller.input.SignUpForm;
import com.jdc.spring.model.account.entity.Account;
import com.jdc.spring.model.account.entity.Account.Role;
import com.jdc.spring.model.account.entity.Customer;
import com.jdc.spring.model.account.repo.AccountRepo;
import com.jdc.spring.model.account.repo.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements SignUpService{
	
	private final PasswordEncoder passwordEncoder;
	private final AccountRepo accountRepo;
	private final CustomerRepo customerRepo;
	
	@Transactional
	public Authentication signUp(SignUpForm signUpForm) {
		var account = new Account();
		account.setEmail(signUpForm.getEmail());
		account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
		account.setRole(Role.Customer);
		accountRepo.save(account);
		
		var customer = new Customer();
		customer.setAccount(account);
		customer.setName(signUpForm.getName());
		customer.setPhone(signUpForm.getPhone());
		customer.setRegisteredAt(LocalDateTime.now());
		customerRepo.save(customer);
		
		return UsernamePasswordAuthenticationToken.unauthenticated(signUpForm.getEmail(), signUpForm.getPassword());
	}

}
