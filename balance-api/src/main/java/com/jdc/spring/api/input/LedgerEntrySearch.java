package com.jdc.spring.api.input;

import java.time.LocalDate;

import com.jdc.spring.model.BalanceType;

public record LedgerEntrySearch(
		String loginId,
		BalanceType type,
		LocalDate from,
		LocalDate to,
		String keyword
		) {

}
