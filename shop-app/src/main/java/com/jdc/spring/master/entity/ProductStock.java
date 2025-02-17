package com.jdc.spring.master.entity;

import com.jdc.spring.model.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class ProductStock extends AbstractEntity {

	@Id
	private int id;
	
	@MapsId
	@OneToOne(optional = true)
	private Product product;
	
	private int stock;
}
