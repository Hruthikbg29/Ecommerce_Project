package com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
