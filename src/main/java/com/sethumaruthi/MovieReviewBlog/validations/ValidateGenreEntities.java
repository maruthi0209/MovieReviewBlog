package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

@Component
public class ValidateGenreEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateGenreEntities.class);
	
	public boolean validateGenre(Genre genre) {
		if (validateGenreDescription(genre.getGenreDescription())) {
			logger.info("Given genre details pass validation check.");
			return true;
		} else {
			logger.info("Given genre details fail validation check.");
			return false;
		}
	}
	
	private boolean validateGenreDescription(String genreDescription) {
		logger.info("Validating genre description from the request body");
		if (genreDescription== null) {
			logger.info("Genre description field is null. Failed validation check.");
			return false;
		}
		if (genreDescription.isBlank() || genreDescription.isEmpty()) {
			logger.info("Genre description is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + genreDescription + " passes validation check.");
		return true;
	}

}
