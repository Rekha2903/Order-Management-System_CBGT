package com.project.ordermanagement.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="Order_Table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	@NotNull (message = "Customer Name is not provided. Please provide Customer Name") 
	private String customerName;
	@NotNull (message = "Date is not provided. Please provide OrderDate")
	private LocalDate orderDate;
	@Valid @NotNull (message = "Items are not selected/provided, order cannot be placed!")
	private ArrayList<OrderItemResponse> orderItems = new ArrayList<OrderItemResponse>();
	@NotNull (message = "Please provide the Shipping address!")
	private String shippingAddress;
	private double total;
}