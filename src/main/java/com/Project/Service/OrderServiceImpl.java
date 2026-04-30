package com.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Project.Entity.Order;
import com.Project.Entity.Product;
import com.Project.Repository.OrderRepository;
import com.Project.Repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
		super();
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}

	@Override
	public Order placeOrder(Order order) {

		Product product = productRepository.findById(order.getProduct().getId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		order.setTotalPrice(product.getPrice() * order.getQuantity());

		order.setStatus("PLACED");

		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getOrdersByUser(Long userId) {
		return orderRepository.findByUserId(userId);
	}

	@Override
	public Order updateStatus(Long id, String status) {

		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		order.setStatus(status);

		return orderRepository.save(order);
	}

}
