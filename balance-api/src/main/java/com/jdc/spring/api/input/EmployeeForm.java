package com.jdc.spring.api.input;

import com.jdc.spring.model.Role;

import jakarta.validation.constraints.NotBlank;

public record EmployeeForm(
		
		@NotBlank(message = "Please enter name.")
		String name,
		
		@NotBlank(message = "Please enter role.")
		Role role,
		
		@NotBlank(message = "Please enter phone.")
		String phone,
		
		@NotBlank(message = "Please enter email.")
		String email
		
		) {
	
	private static final CharSequence DEFAULT_PASS = "123456";

}
