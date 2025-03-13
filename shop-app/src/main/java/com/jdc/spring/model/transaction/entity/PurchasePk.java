package com.jdc.spring.model.transaction.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jdc.spring.master.entity.ProductStockAction;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class PurchasePk implements Serializable, ProductStockAction {
	
	
	@Override
	public LocalDate getIssueAt() {
		return null;
	}

	@Override
	public int getSeqNumber() {
		return 0;
	}
	
	

}
