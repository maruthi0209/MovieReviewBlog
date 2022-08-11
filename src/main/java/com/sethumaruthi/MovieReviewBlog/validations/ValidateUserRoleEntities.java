package com.sethumaruthi.MovieReviewBlog.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;

@Component
public class ValidateUserRoleEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateUserRoleEntities.class);
	
	public boolean validateUserRole(UserRole userRole) {
		if (validateRoleDescription(userRole.getRoleDescription())) {
			logger.info("Given role details pass validation check.");
			return true;
		} else {
			logger.info("Given role details fail validation check.");
			return false;
		}
	}
	
	private boolean validateRoleDescription (String roleDescription) {
		logger.info("Validating user role from the request body");
		if (roleDescription== null) {
			logger.info("Role Description field is null. Failed validation check.");
			return false;
		}
		if (roleDescription.isBlank() || roleDescription.isEmpty()) {
			logger.info("Role Description is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + roleDescription + " passes validation check.");
		return true;
	}

}
