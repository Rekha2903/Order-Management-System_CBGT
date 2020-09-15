package com.project.ordermanagement.service;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.ordermanagement.model.OrderItemResponse;

@FeignClient(url="http://a4lnkml29437.mindtree.com:8081/", name="ORDER-ITEM-SERVICE")
public interface OrderItemClient {
	
	@GetMapping("/items")
	public ResponseEntity<ArrayList<OrderItemResponse>> getOrderItems();

}
