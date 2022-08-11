package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;

@Component
public class ValidateAppUserEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateAppUserEntities.class);
	
	public boolean validateAppUserEntities(AppUser appUser) {
		if (validateUserEmail(appUser.getUserEmail()) && validateUserPassword(appUser.getUserPassword())) {
			logger.info("Given user details passed validation check.");
			return true;
		} else {
			logger.info("Given user details failed validation check.");
			return false;
		}
	}
	
	private boolean validateUserEmail(String userEmail) {
		logger.info("Validating user email from the request body.");
		if (userEmail == null) {
			logger.info("User email field is null. Failed validation check.");
			return false;
		}
		if (userEmail.isBlank() || userEmail.isEmpty()) {
			logger.info("User email field is blank or empty. Failed validation check.");
			return false;
		}
		if (!(userEmail.contains("@") && userEmail.contains("."))) {
			logger.info("User email is not of email format. Failed validation check.");
			return false;
		}
		logger.info("Given " + userEmail + " passes validation check.");
		return true;
	}
	
	private boolean validateUserPassword(String userPassword) {
		logger.info("Validating user password from the request body.");
		if (userPassword == null) {
			logger.info("User password field is null. Failed validation check.");
			return false;
		}
		if (userPassword.isBlank() || userPassword.isEmpty()) {
			logger.info("User password field is blank or empty. Failed validation check.");
			return false;
		}
		if (userPassword.length() < 8) {
			logger.info("User password is not long enough. Failed validation check.");
			return false;
		}
		if (userPassword.length() > 20) {
			logger.info("User password exceeds 20 characters. Failed validation check.");
			return false;
		}
		logger.info("Given user password passes validation check.");
		return true;
	}

}
