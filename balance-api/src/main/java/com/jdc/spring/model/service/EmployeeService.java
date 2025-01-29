package com.jdc.spring.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jdc.spring.model.Commons.getOne;

import java.time.LocalDateTime;
import java.util.function.Function;

import com.jdc.spring.api.input.EmployeeForm;
import com.jdc.spring.api.input.EmployeeSearch;
import com.jdc.spring.api.input.EmployeeStatusForm;
import com.jdc.spring.api.output.EmployeeInfo;
import com.jdc.spring.api.output.EmployeeInfoDetails;
import com.jdc.spring.events.EmployeeChangeEvent;
import com.jdc.spring.model.EmployeeChanges;
import com.jdc.spring.model.entity.Employee;
import com.jdc.spring.model.repo.EmployeeRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

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
	
	public Page<EmployeeInfo> search(EmployeeSearch search, int page, int size) {
		return repo.search(null, null, page, size);
	}
	
	private Function<CriteriaBuilder, CriteriaQuery<EmployeeInfo>> queryFunc(EmployeeSearch search){
		return cb -> {
			var cq = cb.createQuery(EmployeeInfo.class);
			var root = cq.from(Employee.class);
			EmployeeInfo.select(cq,root);
			return cq;
		};
	}

	
	
	public EmployeeInfoDetails findById(int id) {
		return getOne(repo.findById(id).map(EmployeeInfoDetails::from), DOMAIN_NAME, id);
	}
	
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

	public EmployeeForm findByIdForEdit(int id) {
		return getOne(repo.findById(id).map(EmployeeForm::from)
				, DOMAIN_NAME, id);
	}


	
}
