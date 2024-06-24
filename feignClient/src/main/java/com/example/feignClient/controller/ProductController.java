package com.example.feignClient.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignClient.model.Product;
import com.example.feignClient.service.ProductService;

@RestController
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		 CompletableFuture<List<Product>> page1 = productService.getProduct();
		 CompletableFuture<List<Product>> page2 = productService.getProduct();
		 CompletableFuture<List<Product>> page3 = productService.getProduct();

		  // Wait until they are all done
		  CompletableFuture.allOf(page1,page2,page3).join();
		try {
			return Stream.of(page1.get(),page2.get(),page3.get()).flatMap(List::stream).toList();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();
	}
}
