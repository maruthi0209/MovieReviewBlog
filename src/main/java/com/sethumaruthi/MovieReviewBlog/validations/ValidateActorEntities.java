package com.sethumaruthi.MovieReviewBlog.validations;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

@Component
public class ValidateActorEntities {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateActorEntities.class);
	
	public List<String> validateActor(Actor actor) {
		logger.info("Validating the actor object.");
		List<String> validations = new ArrayList<String>();
		validations = validateActorName(actor.getActorName(), validations);
		logger.info("Validated the actor object.");
		return validations;
	}
	
	private List<String> validateActorName(String actorName, List<String> validations) {
		logger.info("Validating actor name from the request body");
		if (actorName== null) {
			validations.add("Actor name field is null. \n");
		}
		else if (actorName.isBlank() || actorName.isEmpty()) {
			validations.add("Actor name field is null. \n");
		} else {
		logger.info("Given " + actorName + " passes validation check.");
		}
		return validations;
	}

}
