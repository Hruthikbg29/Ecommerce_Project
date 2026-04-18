package com.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Project.Entity.Product;
import com.Project.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private  ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	
	public Product saveProduct(Product product) {		
		return repository.save(product);
	}
	
	public List<Product> getAllProducts() {		
		return repository.findAll();
	}
	
	public Product getProductById(Long id) {	
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
	}

	public void deleteProduct(Long id) {
		repository.deleteById(id);
		
	}

}
