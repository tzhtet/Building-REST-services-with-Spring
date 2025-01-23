package com.jdc.spring.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.jdc.spring.mongo.product.Product;
import com.jdc.spring.mongo.product.ProductRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.jdc.spring.mongo.product")
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository repository) {
	    return args -> {
	        System.out.println("CommandLineRunner is executing...");
	        var product = Product.builder()
	                .name("iPhone")
	                .description("Smart Phone")
	                .build();
	        repository.insert(product);
	        System.out.println("Product inserted successfully.");
	    };
	}

}
