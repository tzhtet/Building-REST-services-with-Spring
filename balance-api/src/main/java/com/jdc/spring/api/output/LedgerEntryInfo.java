package com.jdc.spring.api.output;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jdc.spring.model.BalanceType;
import com.jdc.spring.model.entity.Employee;

public record LedgerEntryInfo(
		String id,
		int categoryId,
		String category,
		BalanceType type,
		String issuerId,
		String issuer,
		LocalDate issueAt,
		int items,
		BigDecimal amount,
		String remark
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
