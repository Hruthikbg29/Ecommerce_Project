package com.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserId(Long userId);
	
}
