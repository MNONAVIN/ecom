package com.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	
	@ExceptionHandler(value=CustomerNotFoundException.class) 
	public ResponseEntity<String> handleCustomerNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}
}
