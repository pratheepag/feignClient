package com.example.feignClient.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.feignClient.client.ProductClient;
import com.example.feignClient.model.Product;

@Component
public class ProductFacade {
	/* private ProductClient productClient;
	public ProductFacade(ProductClient productClient) {
		this.productClient = productClient;
	}
	public List<Product> getProducts() {
		return productClient.getProducts();
	} */
}
