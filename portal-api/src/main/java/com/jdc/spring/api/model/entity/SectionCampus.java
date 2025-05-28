package com.jdc.spring.api.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity	
@EqualsAndHashCode(callSuper = false)
public class SectionCampus extends Section  {
	
	
	private int seats;
	private int bufferSeats;
	
	public SectionCampus() {
		setType(Type.Campus);
	}

}
