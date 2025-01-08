package com.jdc.spring.model;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;

public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID>{
	
	private EntityManager em;

	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

}
