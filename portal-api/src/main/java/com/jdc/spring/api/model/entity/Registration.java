package com.jdc.spring.api.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.spring.api.model.AbstractEntity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Registration extends AbstractEntity {
	
	@EmbeddedId
	private RegistrationPk id; 
	
	private LocalDateTime registrationAt;
	private BigDecimal registrationFees;
	private BigDecimal totalFees;
	private BigDecimal discount;
	private BigDecimal totalPaid;
	
	private Status status;
	private LocalDateTime stateChangeAt;
	private String stausChangeReason;
	
	public enum Status{
		Valid,Suspand,Leaved
	}

}
