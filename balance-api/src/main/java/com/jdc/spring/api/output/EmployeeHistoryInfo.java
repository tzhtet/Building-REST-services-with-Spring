package com.jdc.spring.api.output;

import java.time.LocalDateTime;

import com.jdc.spring.model.EmployeeChanges;
import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;

public record EmployeeHistoryInfo(
		String name,
		Role role,
		Status status,
		String phone,
		String email,
		EmployeeChanges changes,
		LocalDateTime changeAt,
		String changeBy
		) {
	
	

}
