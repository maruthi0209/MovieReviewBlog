package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.exception.ValidationException;
import com.sethumaruthi.MovieReviewBlog.models.Actor;
import com.sethumaruthi.MovieReviewBlog.repository.IActorRepository;
import com.sethumaruthi.MovieReviewBlog.service.IActorService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateActorEntities;

@Service
public class ActorServiceImpl implements IActorService{
	
	@Autowired
	private IActorRepository iActorRepository;
	
	@Autowired
	private ValidateActorEntities validateActorEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Actor> getActor(Long actorId) {
			Actor actor = iActorRepository.findById(actorId).orElseThrow(()-> new EntityNotFoundException("Actor with id " + actorId + " was not found"));
			ResponseEntity<Actor> getResponse = new ResponseEntity<>(actor, HttpStatus.OK);
			return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Actor>> getAllActors() {
		List<Actor> actorsList = new ArrayList<Actor>();
		actorsList = iActorRepository.findAll();
		ResponseEntity<List<Actor>> listResponse = new ResponseEntity<>(actorsList, HttpStatus.OK);
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> createActor(Actor actor) {
		List<String> validations = validateActorEntities.validateActor(actor);
		if (validations.size() == 0) {
			Actor savedActor = iActorRepository.save(actor);
			logger.info("Saved actor: " + savedActor.toString());
			logger.info("Actor saved successfully.");
			return new ResponseEntity<>("Actor details saved successfully.", HttpStatus.CREATED);
		} else {
			String respString = new String();
			for (int i = 0; i < validations.size(); i++) { 
				respString = respString.concat(validations.get(i));
			}
			throw new ValidationException(respString);
		}	
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteActor(Long actorId) {
		if (iActorRepository.existsById(actorId)) {
			logger.info("Actor by Id " + actorId + " exists. Deleting it..");
			if (iActorRepository.getMovieListByActor(actorId).isEmpty()) {
				logger.info("This actor has no associated movies.");
			} else {
				iActorRepository.deleteMovieCast(actorId);
				logger.info("Deleted the movie mappings for this actor.");
			}
			iActorRepository.deleteById(actorId);
			logger.info("Actor deleted successfully.");
			return new ResponseEntity<>("Deleted actor " + actorId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete actor with Id: " + actorId + ". Actor with id " + actorId + " was not found", HttpStatus.OK);
		}
	}

}
