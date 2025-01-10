package com.jdc.spring.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdc.spring.model.repo.EmployeeHistoryRepo;
import com.jdc.spring.model.repo.EmployeeRepo;

@Component
public class EmployeeChangeEventListener {

	private static final String EMPLOYEE_DOMAIN = "Employee";

	private static final String ACCOUNT_DOMAIN = "Account";

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeHistoryRepo historyRepo;

}
