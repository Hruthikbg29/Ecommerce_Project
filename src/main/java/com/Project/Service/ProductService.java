package com.Project.Service;

import java.util.List;

import com.Project.Entity.Product;

public interface ProductService {

	Product saveProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	void deleteProduct(Long id);
}
