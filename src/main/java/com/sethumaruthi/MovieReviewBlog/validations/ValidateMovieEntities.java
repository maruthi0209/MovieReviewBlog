package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Movie;

@Component
public class ValidateMovieEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateMovieEntities.class);
	
	public boolean validateMovie(Movie movie) {
		if (validateMovieName(movie.getMovieName()) && validateReleaseDate(movie.getReleaseDate()) && validateNullCheck(movie)
				&& validateMovieBudget(movie.getBudget()) && validateBoxOffice(movie.getBoxOffice())) {
			logger.info("Given movie details passed validation check.");
			return true;
		} else {
			logger.info("Given movie details failed validation check.");
			return false;
		}
	}
	
	private boolean validateMovieName(String movieName) {
		logger.info("Validating movie name from the request body.");
		if (movieName == null) {
			logger.info("Movie name is null. Failed validation check.");
			return false;
		}
		if (movieName.isBlank() || movieName.isEmpty()) {
			logger.info("Movie is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + movieName + " passes validation check.");
		return true;
	}
	
	private boolean validateReleaseDate(String releaseDate) {
		logger.info("Validating movie date from the request body.");
		if (releaseDate == null) {
			logger.info("Movie release date is null. Failed validation check.");
			return false;
		}
		if (releaseDate.isBlank() || releaseDate.isEmpty()) {
			logger.info("Movie release date is blank or empty. Failed validation check.");
			return false;
		}
		if (releaseDate.matches("[!@#$%^&*{}<>+-]*")) {
			logger.info("Movie release date contains special characters. Failed validation check.");
			return false;
		}
		logger.info("Given " + releaseDate + " passed validation check.");
		return true;
	}
	
	private boolean validateNullCheck(Movie movie) {
		logger.info("Checking the budget and boxOffice fields for null value.");
		if (movie.getBudget() == null) {
			logger.info("Movie budget field is null. Failed validation check.");
			return false;
		}
		if (movie.getBoxOffice() == null) {
			logger.info("Movie boxOffice field is null. Failed validation check.");
			return false;
		}
		logger.info("Budget and boxOffice fields passed validation check.");
		return true;
	}
	
	private boolean validateMovieBudget(Long budget) {
		logger.info("Validating movie budget from the request body.");
		if (budget < 0) {
			logger.info("Movie budget is negative. Failed validation check.");
			return false;
		}
		logger.info("Given budget passes validation checks.");
		return true;
	}
	
	private boolean validateBoxOffice(Long boxOffice) {
		logger.info("Validating box office collection from the request body.");
		if (boxOffice < 0) {
			logger.info("Box office collection is negative. Failed validation check.");
			return false;
		}
		logger.info("Given box office collection passes validation checks.");
		return true;
	}

}
