package com.microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.dto.Product;
import com.microservice.exception.CurrencyNotValidExcpetipn;
import com.microservice.exception.OfferNotValidException;
import com.microservice.repository.ProductRepository;
import com.microservice.service.config.ProductConfiguration;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private ProductRepository productRepository;
	private ProductConfiguration productConfiguration;
	
	public Product addProduct(Product product) throws OfferNotValidException {
		if(product.getPrice() == 0 && product.getDiscount() > 0)
		{
			throw new OfferNotValidException("Product having price 0 cannot have discount");
		}
		
		if(!productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase()))
		{
			throw new CurrencyNotValidExcpetipn("Invalid Currency : Valid Currency list is - "+ productConfiguration.getCurrencies() );
		}
		
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

	public Product getProductById(String id) {
		
		return productRepository.findById(id).get();
	}
	
	public String deleteProduct(String id)
	{
		productRepository.deleteById(id);
		return "Product deleted Successfully";
	}

}
