package com.jdc.spring.api.input;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;
import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Employee;

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
	
	
	public Employee entity(PasswordEncoder passwordEncoder) {
		var account = new Account();
		account.setLoginId(email);
		account.setName(name);
		account.setRole(role);
		account.setPassword(passwordEncoder.encode(DEFAULT_PASS));
		
		var employee = new Employee();
		employee.setAccount(account);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setStatus(Status.Applied);
		employee.setStatusChangeAt(LocalDateTime.now());
		
		return employee;
	}

}
