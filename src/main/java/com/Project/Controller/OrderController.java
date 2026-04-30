package com.Project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entity.Order;
import com.Project.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping
	public Order place(@RequestBody Order order) {
		return service.placeOrder(order);
	}
	
	@GetMapping
	public List<Order> all(){
		return service.getAllOrders();
	}
	
	@GetMapping("/user/{userId}")
	public List<Order> byUser(@PathVariable Long userId){
		return service.getOrdersByUser(userId);
	}
	
	
	@PutMapping("/{id}")
	public Order update(@PathVariable Long id , @RequestParam String status) {
		return service.updateStatus(id, status);
	}

}
