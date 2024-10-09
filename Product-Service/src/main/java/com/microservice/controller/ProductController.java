package com.microservice.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.Product;
import com.microservice.exception.OfferNotValidException;
import com.microservice.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) throws OfferNotValidException
	{
		System.out.println("Product name" + product);
		Product savedProduct = productService.addProduct(product);
		//log.info("Product Added");
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@GetMapping("/productList")
	List<Product> getAllProductList()
	{
		
		return productService.getAllProductList();
	}
	@GetMapping("/productList/{category}")
	List<Product> getProductCategoryList(@PathVariable @Valid String category)
	{
		return productService.getProductCategory(category);
	}
	@GetMapping("/product/{id}")
	Product getProductCategoryList(@PathVariable Integer id)
	{
		return productService.getProductById(id);
	}
	@PutMapping("/updateProduct")
	ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Product savedProduct = productService.updateProduct(product);
		//log.info("Product Updated");
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	String deleteProduct(@PathVariable Integer id)
	{	
		return productService.deleteProduct(id);
	}
	
}
