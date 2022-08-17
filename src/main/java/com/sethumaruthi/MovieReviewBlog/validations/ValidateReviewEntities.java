package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Review;

@Component
public class ValidateReviewEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateReviewEntities.class);
	
	public List<String> validateReview(Review review) {
		List<String> validations = new ArrayList<String>();
		validations = validateReviewTitle(review.getReviewTitle(), validations);
		validations = validateReviewDescription(review.getReviewDescription(), validations);
		validations = validateReviewRating(review.getReviewRating(), validations);
		return validations;
	}
	
	private List<String> validateReviewTitle(String reviewTitle, List<String> validations) {
		logger.info("Validating review title from the request body.");
		if (reviewTitle == null) {
			validations.add("Review title is null. \n");
		} else if (reviewTitle.isBlank() || reviewTitle.isEmpty()) {
			logger.info("Failed validation check.");
			validations.add("Review title is blank or empty. \n");
		} else if (reviewTitle.length() < 3 || reviewTitle.length() > 50) {
			logger.info("Failed validation check.");
			validations.add("Review title is not proper length. \n");
		} else {
		logger.info("Given " + reviewTitle + " passes validation check.");
		}
		return validations;
	}
	
	private List<String> validateReviewDescription(String reviewDescription, List<String> validations) {
		logger.info("Validating review description from the request body.");
		if (reviewDescription == null) {
			validations.add("Review description is null. \n");
		} else if (reviewDescription.isBlank() || reviewDescription.isEmpty()) {
			validations.add("Review description is blank or empty. \n");
		} else {
		logger.info("Given review description passes validation check.");
		}
		return validations;
	}
	
	private List<String> validateReviewRating(float reviewRating, List<String> validations) {
		logger.info("Validation review rating from the request body.");
		if (reviewRating <= 0 || reviewRating > 10) {
			validations.add("Review rating should be between 0 and 10. \n");
		} else {
		logger.info("Given review rating passes validation check.");
		}
		return validations;
	}

}
