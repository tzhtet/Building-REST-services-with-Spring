package com.jdc.spring.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.repo.EmployeeRepo;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
	
	private static final String DOMAIN_NAME = "Employee";
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
}
