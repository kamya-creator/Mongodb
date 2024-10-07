package com.microservice.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "product")
public class Product {
	
	private Integer id;
	private String name;
	private Category category;
	private String currency;
	private double price;
	private double discount;
	private String discountDescription;
	private List<String> imageURLs;

}
