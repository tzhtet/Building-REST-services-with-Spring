package com.jdc.spring.controller.output;

import com.jdc.spring.master.entity.ProductStockHistory;
import com.jdc.spring.master.entity.ProductStockHistoryPk;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record StockChangeInfo(
		ProductStockHistoryPk id,
		int beforeStock,
		int quantity,
		String remark,
		String target
		) {
	
	public int getStock() {
		return switch(id.getAction()) {
		case Buy -> beforeStock + quantity;
		case Cancel -> beforeStock + quantity;
		case Sell -> beforeStock - quantity;
		};
	}
	
	public static void select(
			CriteriaBuilder cb,
			CriteriaQuery<StockChangeInfo> cq,
			Root<ProductStockHistory> root
			) {
		
		//var purchaseProduct = cb.treat(root, Purchasepro);
		
	}

}
