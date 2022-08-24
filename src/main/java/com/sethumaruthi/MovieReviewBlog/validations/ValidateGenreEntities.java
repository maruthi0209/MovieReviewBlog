package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

@Component
public class ValidateGenreEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateGenreEntities.class);
	
	public List<String> validateGenre(Genre genre) {
		logger.info("Validating the genre object.");
		List<String> validations = new ArrayList<String>();
		validations = validateGenreDescription(genre.getGenreDescription(), validations);
		logger.info("Validated the genre object.");
		return validations;
	}
	
	private List<String> validateGenreDescription(String genreDescription, List<String> validations) {
		logger.info("Validating genre description from the request body");
		if (genreDescription== null) {
			validations.add("Genre description field is null. \n");
		} else if (genreDescription.isBlank() || genreDescription.isEmpty()) {
			validations.add("Genre description is blank or empty. \n");
		} else {
		logger.info("Given " + genreDescription + " passes validation check.");
		}
		return validations;
	}

}
