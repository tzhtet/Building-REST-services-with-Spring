package com.jdc.spring.api.input;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record LedgerEntryForm(
		
		@NotNull(message = "Please enter issue at.")
		LocalDate issueAt,
		
		@NotNull(message = "Please select category.")
		Integer category,
		
		String remark,
		
		@NotNull(message = "Please enter entry items")
		List<@Valid LedgerEntryFormItem> items
		) {

}
