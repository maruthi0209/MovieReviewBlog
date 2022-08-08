package com.sethumaruthi.MovieReviewBlog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

@Component
public class ValidateEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateEntities.class);
	
	public boolean validateActor(Actor actor) {
		if (validateActorName(actor.getActorName())) {
			logger.debug("Given actor details pass validation check.");
			return true;
		} else {
			logger.debug("Given actor details fail validation check.");
			return false;
		}
	}
	
	private boolean validateActorName(String actorName) {
		logger.debug("Validating actor name from the request body");
		if (actorName== null) {
			logger.debug("Actor name field is null. Failed validation check.");
			return false;
		}
		if (actorName.isBlank() || actorName.isEmpty()) {
			logger.debug("Actor name is blank or empty. Failed validation check.");
			return false;
		}
		logger.debug("Given " + actorName + " passes validation check.");
		return true;
	}

}
