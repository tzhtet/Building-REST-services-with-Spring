package com.jdc.spring.api.input;

import com.jdc.spring.model.BalanceType;

import jakarta.validation.constraints.NotNull;

public record CategorySearch(
		
		@NotNull(message = "Please select balance type.")
		BalanceType type,
		
		@NotNull(message = "Please enter category name.")
		String name,
		
		String description
		
		) {

}
