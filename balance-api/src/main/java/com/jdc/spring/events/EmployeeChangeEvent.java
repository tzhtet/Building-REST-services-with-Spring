package com.jdc.spring.events;

import com.jdc.spring.model.EmployeeChanges;

public record EmployeeChangeEvent(
		EmployeeChanges changes,
		int employeeId	
		) {

}
