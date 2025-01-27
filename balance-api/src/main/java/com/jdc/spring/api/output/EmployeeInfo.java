package com.jdc.spring.api.output;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;

public record EmployeeInfo(
		int id,
		String name,
		Role role,
		Status status,
		String phone,
		String email
		) {

}
