package com.jdc.spring.api.model.entity;

import java.time.LocalDate;

import com.jdc.spring.api.model.AbstractEntity;

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
public class Student extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private LocalDate dob;
	private Gender gender;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Account account;

	private LastEducation education;
	private String major;

	public enum Gender {
		Male, Female
	}

	public enum LastEducation {
		BEHS, Collage, Master, Other
	}
}
