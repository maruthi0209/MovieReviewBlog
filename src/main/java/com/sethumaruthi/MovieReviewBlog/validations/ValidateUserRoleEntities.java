package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;

@Component
public class ValidateUserRoleEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateUserRoleEntities.class);
	
	public List<String> validateUserRole(UserRole userRole) {
		List<String> validations = new ArrayList<String>();
		validations = validateRoleDescription(userRole.getRoleDescription(), validations);
		return validations;
	}
	
	private List<String> validateRoleDescription (String roleDescription, List<String> validations) {
		logger.info("Validating user role from the request body");
		if (roleDescription== null) {
			logger.info(" Failed validation check.");
			validations.add("Role Description field is null. \n");
		} else if (roleDescription.isBlank() || roleDescription.isEmpty()) {
			validations.add("Role Description is blank or empty.  \n");
		} else {
		logger.info("Given " + roleDescription + " passes validation check.");
		}
		return validations;
	}

}
