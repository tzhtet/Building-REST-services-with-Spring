package com.jdc.spring.api.input;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;

public record EmployeeSearch(
		
		Role role,
		Status status,
		String keyword
		) {

	
}
