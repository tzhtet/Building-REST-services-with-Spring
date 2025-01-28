package com.jdc.spring.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jdc.spring.model.Commons.getOne;

import java.time.LocalDateTime;

import com.jdc.spring.api.input.EmployeeForm;
import com.jdc.spring.api.input.EmployeeStatusForm;
import com.jdc.spring.api.output.EmployeeInfo;
import com.jdc.spring.events.EmployeeChangeEvent;
import com.jdc.spring.model.EmployeeChanges;
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
	
	public EmployeeInfo create(EmployeeForm form) {
		var entity = form.entity(passwordEncoder);
		
		entity = repo.saveAndFlush(entity);
		
		eventPublisher.publishEvent(new EmployeeChangeEvent(EmployeeChanges.Creation, entity.getId()));
		
		return EmployeeInfo.from(entity);
	}

	@Transactional
	public EmployeeInfo update(int id, EmployeeStatusForm form) {
		var entity = getOne(repo.findById(id), DOMAIN_NAME, id);
		entity.setStatus(form.status());
		entity.setStatusChangeAt(LocalDateTime.now());
		
		eventPublisher.publishEvent(new EmployeeChangeEvent(EmployeeChanges.StatusChange, entity.getId()));
		return EmployeeInfo.from(entity);
	}
	
}
