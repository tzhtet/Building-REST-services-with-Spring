package com.jdc.spring.api.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Course {
	
	private int id;
	private String name;
	private Level level;
	private String description;
	private String icon;
	
	
	public enum FeesType{
		Campus,Zoom,Video
	}
	
	public enum Level{
		Basic,Intermediate,Advance
	}

}
