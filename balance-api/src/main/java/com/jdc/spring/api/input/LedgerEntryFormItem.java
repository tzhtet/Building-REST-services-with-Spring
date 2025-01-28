package com.jdc.spring.api.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record LedgerEntryFormItem(
		
		@NotBlank(message = "Please enter item name.")
		String item,
		
		@NotBlank(message = "Please enter quantity.")
		Integer quantity,
		
		@NotBlank(message = "Please enter price.")
		BigDecimal unitPrice
		) {

}
