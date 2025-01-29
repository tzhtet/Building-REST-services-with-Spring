package com.jdc.spring.api.output;

import com.jdc.spring.model.Role;
import com.jdc.spring.model.Status;
import com.jdc.spring.model.entity.Employee;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

	public static void select(CriteriaQuery<EmployeeInfo> cq, Root<Employee> root) {
		//var account = root.join(Employee_.account);
	}

}
