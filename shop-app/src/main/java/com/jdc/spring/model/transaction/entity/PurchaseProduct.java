package com.jdc.spring.model.transaction.entity;

import com.jdc.spring.master.entity.ProductStockHistory;
import com.jdc.spring.master.entity.ProductStockHistoryPk;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class PurchaseProduct extends ProductStockHistory {
	
	public PurchaseProduct() {
		var pk = new ProductStockHistoryPk();
		pk.setAction(Action.Buy);
		setId(pk);
	}
	

}
