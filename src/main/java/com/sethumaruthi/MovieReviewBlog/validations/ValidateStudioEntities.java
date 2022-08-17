package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Studio;

@Component
public class ValidateStudioEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateStudioEntities.class);
	
	public List<String> validateStudio (Studio studio) {
		List<String> validations = new ArrayList<String>();
		validations = validateStudioName(studio.getStudioName(), validations);
		return validations;
	}
	
	private List<String> validateStudioName(String studioName, List<String> validations) {
		logger.info("Validating studio name from the request body");
		if (studioName== null) {
			validations.add("Studio name field is null. \n");
		} else if (studioName.isBlank() || studioName.isEmpty()) {
			validations.add("Studio name is blank or empty. \n");
		} else {
		logger.info("Given " + studioName + " passes validation check.");
		}
		return validations;
	}


}
