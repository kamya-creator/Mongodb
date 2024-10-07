package com.microservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.microservice.dto.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	
	@Query("{'Category.name':?0}")
	List<Product> findByCategory(String category);

}
