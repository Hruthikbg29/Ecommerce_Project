package com.Project.Service;

import java.util.List;

import com.Project.Entity.Category;

public interface CategoryService {

	Category saveCategory(Category category);
	
	List<Category> getAllCategories();
	
	Category getCategoryByID(Long id);
	
	void deleteCategory(Long id);
}
