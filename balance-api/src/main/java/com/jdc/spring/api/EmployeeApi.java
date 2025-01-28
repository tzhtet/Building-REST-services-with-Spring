package com.jdc.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.api.input.EmployeeForm;
import com.jdc.spring.api.input.EmployeeStatusForm;
import com.jdc.spring.api.output.EmployeeInfo;
import com.jdc.spring.model.service.EmployeeService;

@RestController
@RequestMapping("employee")
@PreAuthorize("hasAnyAuthority('Admin', 'Manager')")
public class EmployeeApi {
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping
	EmployeeInfo create(
			@Validated @RequestBody EmployeeForm form, 
			BindingResult result) {
		
		return service.create(form);
		
	}
	
	@PutMapping("{id}")
	EmployeeInfo update(@PathVariable int id,
			@Validated @RequestBody EmployeeStatusForm form, BindingResult result) {
		return service.update(id,form);
	}

}
