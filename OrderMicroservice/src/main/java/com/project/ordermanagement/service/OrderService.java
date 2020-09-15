package com.project.ordermanagement.service;

import java.time.LocalDate;
import java.util.List;

import com.project.ordermanagement.model.Order;

public interface OrderService {

	Order createOrder(Order order);
	
	List<Order> retrieveOrders();
	
	Order retrieveOrderByOrderId(int orderId);
	
	List<Order> retrieveOrderItemByCustomerName(String customerName);
	
	List<Order> retrieveOrderByDate(LocalDate orderDate);
	
	long orderCount();
}
