package com.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByName(String name);
	
	void deleteById(Long id);
	
	Optional<Category> findById(Long id);
	

}
