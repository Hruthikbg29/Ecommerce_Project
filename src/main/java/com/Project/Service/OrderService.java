package com.Project.Service;

import java.util.List;

import com.Project.Entity.Order;

public interface OrderService {

	Order placeOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getOrdersByUser(Long userId);

    Order updateStatus(Long id, String status);
}
