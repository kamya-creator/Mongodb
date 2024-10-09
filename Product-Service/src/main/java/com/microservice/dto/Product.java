package com.microservice.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "product")
public class Product {
	
	@Id
	private String id;
	@NotNull(message = "Product name can't be null")	
	private String name;
	
	@NotNull(message = "Category can't be null")	
	private Category category;
	private String currency;
	
	@Min(0)
	private double price;
	@Max(100)
	private double discount;
	private String discountDescription;
	private List<String> imageURLs;
	
	
}
