package com.jdc.spring.api.model;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;

public class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
 
	private EntityManager em;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

}
