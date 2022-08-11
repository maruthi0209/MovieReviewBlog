package com.sethumaruthi.MovieReviewBlog.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
		
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<String> handleValidationException(ValidationException exception) {
		logger.info("Validation exception occured.");
		return new ResponseBuilder().buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
	}

}
