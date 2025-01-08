package com.jdc.spring.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Account {
	
	
	private int id;
	private String loginId;
	private String name;
	private String password;

}
