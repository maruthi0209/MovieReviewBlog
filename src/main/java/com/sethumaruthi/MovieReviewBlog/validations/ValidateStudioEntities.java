package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Studio;

@Component
public class ValidateStudioEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateStudioEntities.class);
	
	public boolean validateStudio (Studio studio) {
		if (validateStudioName(studio.getStudioName())) {
			logger.info("Given studio  details pass validation check.");
			return true;
		} else {
			logger.info("Given studio details fail validation check.");
			return false;
		}
	}
	
	private boolean validateStudioName(String studioName) {
		logger.info("Validating studio name from the request body");
		if (studioName== null) {
			logger.info("Studio name field is null. Failed validation check.");
			return false;
		}
		if (studioName.isBlank() || studioName.isEmpty()) {
			logger.info("Studio name is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + studioName + " passes validation check.");
		return true;
	}


}
