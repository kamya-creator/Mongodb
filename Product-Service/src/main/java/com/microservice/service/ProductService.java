package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.Product;
import com.microservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		Product savedProduct= productRepository.save(product);
		return savedProduct;
	}

	public List<Product> getAllProductList() {
		return productRepository.findAll();
	}

	public List<Product> getProductCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Integer id) {
		
		return productRepository.findById(id).get();
	}
	
	public String deleteProduct(Integer id)
	{
		productRepository.deleteById(id);
		return "Product deleted Successfully";
	}

}
