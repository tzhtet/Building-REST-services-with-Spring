package com.jdc.spring.mongo.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

}
