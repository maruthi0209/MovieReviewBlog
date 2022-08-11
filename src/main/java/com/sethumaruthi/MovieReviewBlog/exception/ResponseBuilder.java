package com.sethumaruthi.MovieReviewBlog.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
	
	public static final Logger logger = LoggerFactory.getLogger(ResponseBuilder.class);
	
	public ResponseEntity<String> buildResponse(HttpStatus statusCode, String responseMessage){
		logger.info("Generating a standard response...");
		StandardResponse response = new StandardResponse(responseMessage);
		return new ResponseEntity<String>(responseMessage, statusCode);
	}

}
