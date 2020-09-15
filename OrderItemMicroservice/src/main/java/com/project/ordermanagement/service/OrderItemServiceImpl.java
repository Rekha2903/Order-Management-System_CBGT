package com.project.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.ordermanagement.model.OrderItem;
import com.project.ordermanagement.repository.OrderItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly=true)
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired 
	OrderItemRepository itemRepo;

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public OrderItem createOrderItem(OrderItem orderItem) {
		return itemRepo.save(orderItem);
	}

	@Override
	public List<OrderItem> retrieveOrderItems() {
		return (List<OrderItem>) itemRepo.findAll();
	}

	@Override
	public OrderItem retrieveOrderItemByProductCode(int productCode) {
		Optional<OrderItem> optional = itemRepo.findById(productCode);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public OrderItem retrieveOrderItemByProductName(String productName) {
		return Optional.ofNullable(itemRepo.findByProductName(productName)).orElse(null);
	}

	@Override
	public long itemCount() {
		long count = itemRepo.count();
		log.debug("Items count {}", count);
		return count;
	}

}
