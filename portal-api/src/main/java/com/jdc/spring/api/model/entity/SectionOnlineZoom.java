package com.jdc.spring.api.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class SectionOnlineZoom extends SectionOnline{
	
	
	public SectionOnlineZoom(){
		setTeachingMethod(Teaching.Zoom);
	}

}
