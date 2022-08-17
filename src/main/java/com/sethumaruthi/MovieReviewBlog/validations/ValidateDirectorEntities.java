package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Director;

@Component
public class ValidateDirectorEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateDirectorEntities.class);

	public List<String> validateDirector(Director director) {
		List<String> validations = new ArrayList<String>();
		validations = validateDirectorName(director.getDirectorName(), validations);
		return validations;
	}
	
	private List<String> validateDirectorName(String directorName, List<String> validations) {
		logger.info("Validating director name from the request body");
		if (directorName== null) {
			validations.add("Director name field is null. \n");
		} else if (directorName.isBlank() || directorName.isEmpty()) {
			validations.add("Director name is blank or empty. \n");
		} else {
		logger.info("Given " + directorName + " passes validation check.");
		}
		return validations;
	}

}
