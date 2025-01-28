package com.jdc.spring.api.input;

import com.jdc.spring.model.Status;

public record EmployeeStatusForm(
		
		Status status,
		String reason
		) {

}
