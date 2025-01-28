package com.jdc.spring.api.output;

import java.math.BigDecimal;

public record LedgerEntryInfoItem(
		String item,
		int quantity,
		BigDecimal unitPrice
		) {

}
