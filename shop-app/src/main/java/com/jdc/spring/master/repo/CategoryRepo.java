package com.jdc.spring.master.repo;

import java.util.Optional;
import java.util.function.Function;

import com.jdc.spring.controller.output.CategoryInfo;
import com.jdc.spring.master.entity.Category;
import com.jdc.spring.model.BaseRepository;
import com.jdc.spring.model.PageInfo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public interface CategoryRepo extends BaseRepository<Category, Integer>{
	
	long countByNameIgnoreCase(String name);
	
	Optional<Category> findOneByName(String name);

	PageInfo<CategoryInfo> search(Function<CriteriaBuilder, CriteriaQuery<CategoryInfo>> function, Function<CriteriaBuilder, CriteriaQuery<Long>> function2, int page, int size);

}
