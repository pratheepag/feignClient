package com.example.feignClient.client;

import java.util.List;

import com.example.feignClient.model.Product;

import feign.RequestLine;

public interface ProductClient {
	@RequestLine("GET /products")
	List<Product> getProducts();
}
