package com.project.ordermanagement.exception;

public class OrderItemNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException() {
		super();
	}

	public OrderItemNotFoundException(String message) {
		super(message);
	}
	
	public OrderItemNotFoundException(String message, Throwable throwableInstance) {
		super(message, throwableInstance);
	}

}
