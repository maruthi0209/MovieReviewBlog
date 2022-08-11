package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Review;

@Component
public class ValidateReviewEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateReviewEntities.class);
	
	public boolean validateReview(Review review) {
		if (validateReviewTitle(review.getReviewTitle()) && validateReviewDescription(review.getReviewDescription()) && validateReviewRating(review.getReviewRating())) {
			logger.info("Given review details passed validation check.");
			return true;
		} else {
			logger.info("Given review details failed validation check.");
			return false;
		}
	}
	
	private boolean validateReviewTitle(String reviewTitle) {
		logger.info("Validating review title from the request body.");
		if (reviewTitle == null) {
			logger.info("Review title is null. Failed validation check.");
			return false;
		}
		if (reviewTitle.isBlank() || reviewTitle.isEmpty()) {
			logger.info("Review title is blank or empty. Failed validation check.");
			return false;
		}
		if (reviewTitle.length() < 3 || reviewTitle.length() > 50) {
			logger.info("Review title is not proper length. Failed validation check.");
			return false;
		}
		logger.info("Given " + reviewTitle + " passes validation check.");
		return true;
	}
	
	private boolean validateReviewDescription(String reviewDescription) {
		logger.info("Validating review description from the request body.");
		if (reviewDescription == null) {
			logger.info("Review description is null. Failed validation check.");
			return false;
		}
		if (reviewDescription.isBlank() || reviewDescription.isEmpty()) {
			logger.info("Review description is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given review description passes validation check.");
		return true;
	}
	
	private boolean validateReviewRating(float reviewRating) {
		logger.info("Validation review rating from the request body.");
		if (reviewRating <= 0 || reviewRating > 10) {
			logger.info("Review rating should be between 0 and 10. Failed validation check.");
			return false;
		}
		logger.info("Given review rating passes validation check.");
		return true;
	}

}
