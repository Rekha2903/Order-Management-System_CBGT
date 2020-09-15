package com.project.ordermanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ordermanagement.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

	OrderItem findByProductName(String productName);

}