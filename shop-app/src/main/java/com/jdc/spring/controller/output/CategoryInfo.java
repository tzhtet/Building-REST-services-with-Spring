package com.jdc.spring.controller.output;

import com.jdc.spring.master.entity.Category;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CategoryInfo {

	public static void select(CriteriaBuilder cb, CriteriaQuery<CategoryInfo> cq, Root<Category> root) {
		
	}

}
