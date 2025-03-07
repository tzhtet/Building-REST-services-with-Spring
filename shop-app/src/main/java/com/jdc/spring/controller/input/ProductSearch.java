package com.jdc.spring.controller.input;

public record ProductSearch(
		Integer supplierId,
		String keyword,
		Integer stockFrom,
		Integer stockTo
		) {

}
