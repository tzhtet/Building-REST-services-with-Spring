package com.jdc.spring.master.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockHistoryPk implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	@Column(name = "issue_at")
	private LocalDate issueAt;
	
	@Column(name = "product_id")
	private int productId;
	
	private int seqNumber;

}
