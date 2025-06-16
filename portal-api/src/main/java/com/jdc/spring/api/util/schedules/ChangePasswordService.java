package com.jdc.spring.api.util.schedules;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.api.controller.authenticated.input.ChangePasswordRequest;
import com.jdc.spring.api.controller.authenticated.output.ChangePasswordResponse;
import com.jdc.spring.api.model.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {
	
	private final AccountRepo accountRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public ChangePasswordResponse execute(ChangePasswordRequest req) {
		return null;
	}
}
