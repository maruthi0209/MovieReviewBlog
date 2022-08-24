package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;

@Component
public class ValidateAppUserEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateAppUserEntities.class);
	
	public List<String> validateAppUserEntities(AppUser appUser) {
		logger.info("Validating the user object.");
		List<String> validations = new ArrayList<String>();
		validations = validateUserEmail(appUser.getUserEmail(), validations);
		validations = validateUserPassword(appUser.getUserPassword(), validations);
		logger.info("Validated the user object.");
		return validations;
	}
	
	private List<String> validateUserEmail(String userEmail, List<String> validations) {
		logger.info("Validating user email from the request body.");
		if (userEmail == null) {
			validations.add("User email field is null. \n");
		} else if (userEmail.isBlank() || userEmail.isEmpty()) {
			logger.info(" Failed validation check.");
			validations.add("User email field is blank or empty. \n");
		} else if (!(userEmail.contains("@") && userEmail.contains("."))) {
			validations.add("User email is not of email format. \n");
		} else {
		logger.info("Given " + userEmail + " passes validation check.");
		}
		return validations;
	}
	
	private List<String> validateUserPassword(String userPassword, List<String> validations) {
		logger.info("Validating user password from the request body.");
		if (userPassword == null) {
			validations.add("User password field is null. \n");
		} else if (userPassword.isBlank() || userPassword.isEmpty()) {
			logger.info("Failed validation check.");
			validations.add("User password field is blank or empty. \n");
		} else if (userPassword.length() < 8) {
			logger.info("Failed validation check.");
			validations.add("User password is not long enough. \n");
		} else if (userPassword.length() > 20) {
			validations.add("User password exceeds 20 characters. \n");
		} else {
		logger.info("Given user password passes validation check.");
		}
		return validations;
	}

}
