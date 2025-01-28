package com.jdc.spring.api.output;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;
import com.jdc.spring.model.entity.Employee;

public record EmployeeInfo(
		int id,
		String name,
		Role role,
		Status status,
		String phone,
		String email
		) {
	
	public static EmployeeInfo from(Employee entity) {
		return new EmployeeInfo(
				entity.getId(),
				entity.getAccount().getName(),
				entity.getAccount().getRole(),
				entity.getStatus(),
				entity.getPhone(),
				entity.getEmail());
	}

}
