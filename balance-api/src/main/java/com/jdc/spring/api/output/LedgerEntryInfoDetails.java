package com.jdc.spring.api.output;

import java.util.List;

public record LedgerEntryInfoDetails(
		LedgerEntryInfo info,
		List<LedgerEntryInfoItem> items
		) {

}
