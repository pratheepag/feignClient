package com.example.feignClient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignClient.client.ProductClient;
import com.example.feignClient.model.Product;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@RestController
public class ProductController {
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		ProductClient productClient = Feign.builder()
				.encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ProductClient.class, "http://localhost:8090");
		return productClient.getProducts();
	}
}
