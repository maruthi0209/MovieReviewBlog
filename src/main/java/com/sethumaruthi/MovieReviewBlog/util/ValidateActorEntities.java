package com.sethumaruthi.MovieReviewBlog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

@Component
public class ValidateActorEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateActorEntities.class);
	
	public boolean validateActor(Actor actor) {
		if (validateActorName(actor.getActorName())) {
			logger.info("Given actor details pass validation check.");
			return true;
		} else {
			logger.info("Given actor details fail validation check.");
			return false;
		}
	}
	
	private boolean validateActorName(String actorName) {
		logger.info("Validating actor name from the request body");
		if (actorName== null) {
			logger.info("Actor name field is null. Failed validation check.");
			return false;
		}
		if (actorName.isBlank() || actorName.isEmpty()) {
			logger.info("Actor name is blank or empty. Failed validation check.");
			return false;
		}
		logger.info("Given " + actorName + " passes validation check.");
		return true;
	}

}
