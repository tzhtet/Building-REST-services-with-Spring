package com.jdc.spring.api.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Payment {

	@EmbeddedId
	private PaymentPk id;
	
	private BigDecimal amount;
	private LocalDateTime paymentAt;
	private Type type;
	private String screenShot;
	private boolean confirmed;
	private LocalDateTime confirmedAt;
	
	public enum Type{
		Campus,Online
	}
	
}
