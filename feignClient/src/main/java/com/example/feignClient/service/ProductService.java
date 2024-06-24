package com.example.feignClient.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.feignClient.client.ProductClient;
import com.example.feignClient.model.Product;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Component
public class ProductService {

	@Async
	public CompletableFuture<List<Product>> getProduct() {
		ProductClient productClient = Feign.builder()
				.encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ProductClient.class, "http://localhost:8090");
		return CompletableFuture.completedFuture(productClient.getProducts());
	}
}
