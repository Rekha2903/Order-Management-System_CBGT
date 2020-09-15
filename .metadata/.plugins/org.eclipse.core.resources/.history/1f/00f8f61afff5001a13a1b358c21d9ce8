package com.project.ordermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalApplicationExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(OrderItemNotFoundException.class)
    public final ResponseEntity<Object> handleOrderItemNotFoundException(OrderItemNotFoundException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(OrderItemNotCreatedException.class)
    public final ResponseEntity<Object> handleOrderItemNotCreatedException(OrderItemNotCreatedException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
