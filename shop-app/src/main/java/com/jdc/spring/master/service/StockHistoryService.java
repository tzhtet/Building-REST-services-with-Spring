package com.jdc.spring.master.service;

import org.springframework.stereotype.Service;

import com.jdc.spring.master.repo.ProductStockHistoryRepo;
import com.jdc.spring.model.PageInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockHistoryService {
	
	private final ProductStockHistoryRepo historyRepo;
	

}
