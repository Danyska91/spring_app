package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.domain.entity.Product;
import com.example.demo.dto.ProductDto;


public interface ProductService {

	List<Product> findAllProduct();
	Product findProductById(Long id);
	Product createProduct(ProductDto productDto);
	Product updateProduct(ProductDto productDto);
	Product updateProductPriceById(Long id, BigDecimal price);
	void disableProductById(Long id);//deshabilitar un producto por id
}
	
