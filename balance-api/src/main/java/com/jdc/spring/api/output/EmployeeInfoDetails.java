package com.jdc.spring.api.output;

import java.util.List;

import com.jdc.spring.model.entity.Employee;

public record EmployeeInfoDetails(
		EmployeeInfo info,
		List<EmployeeHistoryInfo> history
		) {
	
	
	public static EmployeeInfoDetails from(Employee entity) {
		return new EmployeeInfoDetails(
				EmployeeInfo.from(entity),
				entity.getHistories().stream().map(EmployeeHistoryInfo::from).toList());
	}

}
