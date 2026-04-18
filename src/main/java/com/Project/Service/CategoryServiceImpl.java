package com.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Project.Entity.Category;
import com.Project.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository repository;
	
	public CategoryServiceImpl(CategoryRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Category saveCategory(Category category) {
		return repository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return  repository.findAll();
	}

	@Override
	public Category getCategoryByID(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("category not found"));
	}

	@Override
	public void deleteCategory(Long id) {
		repository.deleteById(id);
	}

}
