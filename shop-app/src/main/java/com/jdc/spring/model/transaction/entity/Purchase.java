package com.jdc.spring.model.transaction.entity;

import com.jdc.spring.model.AbstractEntity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Purchase extends AbstractEntity{
	

}
