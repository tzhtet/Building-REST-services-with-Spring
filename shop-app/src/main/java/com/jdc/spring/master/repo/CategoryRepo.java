package com.jdc.spring.master.repo;

import java.util.Optional;

import com.jdc.spring.master.entity.Category;
import com.jdc.spring.model.BaseRepository;

public interface CategoryRepo extends BaseRepository<Category, Integer>{
	
	long countByNameIgnoreCase(String name);
	
	Optional<Category> findOneByName(String name);

}
