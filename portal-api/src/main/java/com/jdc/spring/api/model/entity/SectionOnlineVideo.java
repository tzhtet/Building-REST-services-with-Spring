package com.jdc.spring.api.model.entity;

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class SectionOnlineVideo extends SectionOnline{
	
	@Column(columnDefinition = "TEXT")
	private Map<String, Integer> videoFiles;
	
	@Column(columnDefinition = "TEXT")
	private Map<String, Integer> hours;
	
	public SectionOnlineVideo() {
		setTeachingMethod(Teaching.Video);
	}

}
