package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Director;

@Component
public class ValidateDirectorEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateDirectorEntities.class);

	public boolean validateDirector(Director director) {
		if (validateDirectorName(director.getDirectorName())) {
			logger.info("Given director details pass validation check.");
			return true;
		} else {
			logger.info("Given director details fail validation check.");
			return false;
		}
	}
	
	private boolean validateDirectorName(String directorName) {
		logger.info("Validating director name from the request body");
		if (directorName== null) {
			logger.info("Director name field is null. Failed validation check.");
			return false;
		}
		if (directorName.isBlank() || directorName.isEmpty()) {
			logger.info("Director name is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + directorName + " passes validation check.");
		return true;
	}

}
