package com.jdc.spring.api.output;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jdc.spring.model.BalanceType;

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

}
