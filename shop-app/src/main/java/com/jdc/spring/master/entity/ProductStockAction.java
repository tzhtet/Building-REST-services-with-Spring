package com.jdc.spring.master.entity;

import java.time.LocalDate;

public interface ProductStockAction {
	
	LocalDate getIssueAt();
	int getSeqNumber();

}
