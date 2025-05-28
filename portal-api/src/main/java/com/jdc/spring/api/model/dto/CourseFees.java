package com.jdc.spring.api.model.dto;

import java.math.BigDecimal;

public abstract class CourseFees {
	
	public enum Type{
		Monthly,Total
	}
	
	private Type type;
	
	public abstract BigDecimal getTotal();

}
