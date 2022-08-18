package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Movie;

@Component
public class ValidateMovieEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateMovieEntities.class);
	
	public List<String> validateMovie(Movie movie) {
		List<String> validations = new ArrayList<String>();
		validations = validateMovieName(movie.getMovieName(), validations);
		validations = validateReleaseDate(movie.getReleaseDate(), validations);
		validations = validateNullCheck(movie, validations);
		validations = validateMovieBudget(movie.getBudget(), validations);
		validations = validateBoxOffice(movie.getBoxOffice(), validations);
		return validations;
	}
	
	private List<String> validateMovieName(String movieName, List<String> validations) {
		logger.info("Validating movie name from the request body.");
		if (movieName == null) {
			validations.add("Movie name is null. \n");
		} else if (movieName.isBlank() || movieName.isEmpty()) {
			validations.add("Movie is blank or empty. \n");
		} else {
		logger.info("Given " + movieName + " passes validation check.");
		}
		return validations;
	}
	
	private List<String> validateReleaseDate(String releaseDate, List<String> validations) {
		logger.info("Validating movie date from the request body.");
		if (releaseDate == null) {
			validations.add("Movie release date is null. \n");
		} else if (releaseDate.isBlank() || releaseDate.isEmpty()) {
			validations.add("Movie release date is blank or empty. \n");
		} else if (releaseDate.matches("[!@#$%^&*{}<>+-]*")) {
			validations.add("Movie release date contains special characters. \n");
		} else {
		logger.info("Given " + releaseDate + " passed validation check.");
		}
		return validations;
	}
	
	private List<String> validateNullCheck(Movie movie, List<String> validations) {
		logger.info("Checking the budget and boxOffice fields for null value.");
		if (movie.getBudget() == null) {
			validations.add("Movie budget field is null. \n");
		} else if (movie.getBoxOffice() == null) {
			validations.add("Movie boxOffice field is null. \n");
		} else {
		logger.info("Budget and boxOffice fields passed validation check.");
		}
		return validations;
	}
	
	private List<String> validateMovieBudget(Long budget, List<String> validations) {
		logger.info("Validating movie budget from the request body.");
		if (budget < 0) {
			validations.add("Movie budget is negative. \n");
		} else {
		logger.info("Given budget passes validation checks.");
		}
		return validations;
	}
	
	private List<String> validateBoxOffice(Long boxOffice, List<String> validations) {
		logger.info("Validating box office collection from the request body.");
		if (boxOffice < 0) {
			validations.add("Box office collection is negative. \n");
		} else {
		logger.info("Given box office collection passes validation checks.");
		}
		return validations;
	}

}
