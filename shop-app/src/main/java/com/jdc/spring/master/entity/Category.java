package com.jdc.spring.master.entity;

import java.util.List;

import com.jdc.spring.model.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Category extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	public Category(String name) {
		super();
		this.name = name;
	}

}
