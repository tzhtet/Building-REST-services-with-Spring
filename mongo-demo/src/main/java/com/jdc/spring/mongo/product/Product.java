package com.jdc.spring.mongo.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
@Builder
public class Product {
	
	@Id
	private String id;
	
	private String name;
	
	private String description;

}
