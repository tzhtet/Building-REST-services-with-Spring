package com.jdc.spring.api.output;

import java.time.LocalDateTime;

import com.jdc.spring.model.EmployeeChanges;
import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;
import com.jdc.spring.model.entity.EmployeeHistory;

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
	
	public static EmployeeHistoryInfo from(EmployeeHistory entity) {
		return new  EmployeeHistoryInfo(
				entity.getName(),
				entity.getRole(),
				entity.getStatus(),
				entity.getPhone(),
				entity.getEmail(),
				entity.getChanges(), 
				entity.getChangeAt(),
				entity.getChangeBy());
	}
	

}
