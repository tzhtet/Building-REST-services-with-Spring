package com.jdc.spring.api.model.entity;

import java.time.LocalDate;

import com.jdc.spring.api.model.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Employee extends AbstractEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Type type;
	
	@Column(nullable = false)
	private String name;
	
	private LocalDate dob;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Account account;
	
	@Column(nullable = false)
	private LocalDate assignAt;
	private LocalDate resignAt;
	private String resignReason;
	
	public enum Type{
		Office,Teacher,Management
	}

}
