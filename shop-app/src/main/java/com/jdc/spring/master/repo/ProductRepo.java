package com.jdc.spring.master.repo;

import java.util.Optional;

import com.jdc.spring.master.entity.Product;
import com.jdc.spring.model.BaseRepository;

public interface ProductRepo extends BaseRepository<Product, Integer> {
	
	Optional<Product> findOneByCategoryIdAndName(int categoryId, String name);

}
