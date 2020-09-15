package com.project.ordermanagement.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ordermanagement.ErrorCodes;
import com.project.ordermanagement.exception.OrderItemNotCreatedException;
import com.project.ordermanagement.exception.OrderItemNotFoundException;
import com.project.ordermanagement.model.OrderItem;
import com.project.ordermanagement.service.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class OrderItemController {
	
	@Autowired 
	OrderItemService itemService;
	@Autowired
	MessageSource message;
	
	@GetMapping("/items")
	public ResponseEntity<ArrayList<OrderItem>> getOrderItems(){
		ArrayList<OrderItem> itemList = (ArrayList<OrderItem>) itemService.retrieveOrderItems();
		log.debug("Items returned {}", itemList);
		return new ResponseEntity<ArrayList<OrderItem>>(itemList, HttpStatus.OK);
		
	}
	
	@PostMapping("/item")
	public ResponseEntity<OrderItem> addOrderItem(@RequestBody @Valid OrderItem item,Locale locale) {
		OrderItem itemCreated = itemService.createOrderItem(item);
		if (itemCreated == null) {
			log.error("Something went wrong so item was not saved");
			throw new OrderItemNotCreatedException(message.getMessage(ErrorCodes.ORDERITEMNOTSAVED, null, locale));
		}else {
			log.debug("Item added successfully {}",itemCreated);
			return new ResponseEntity<OrderItem>(itemCreated, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/itemByCode/{itemCode}")
	public ResponseEntity<OrderItem> getOrderItemByProductCode(@PathVariable int itemCode,Locale locale){
		OrderItem item = itemService.retrieveOrderItemByProductCode(itemCode);
		if(null!=item) {
			log.debug("Item found {}", item);
			return new ResponseEntity<OrderItem>(item, HttpStatus.OK);
		}else {
			log.error("Item not found!!");
			throw new OrderItemNotFoundException(message.getMessage(ErrorCodes.ORDERITEMNOTFOUND, null, locale));
		}
	}
	
	@GetMapping("/itemByName/{itemName}")
	public ResponseEntity<OrderItem> getOrderItemByProductName(@PathVariable String itemName,Locale locale){
		OrderItem item = itemService.retrieveOrderItemByProductName(itemName);
		if(null!=item) {
			log.debug("Item found {}", item);
			return new ResponseEntity<OrderItem>(item, HttpStatus.OK);
		}else {
			log.error("Item not found!!");
			throw new OrderItemNotFoundException(message.getMessage(ErrorCodes.ORDERITEMNOTFOUND, null, locale));
		}
	}
	
	@GetMapping("/totalItemsAvailable")
	public ResponseEntity<?> getOrderItemCount(){
		return new ResponseEntity<>(itemService.itemCount(), HttpStatus.OK);
	}
}
