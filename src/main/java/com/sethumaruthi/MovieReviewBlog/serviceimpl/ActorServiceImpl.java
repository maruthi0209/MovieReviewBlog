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

import com.sethumaruthi.MovieReviewBlog.models.Actor;
import com.sethumaruthi.MovieReviewBlog.repository.IActorRepository;
import com.sethumaruthi.MovieReviewBlog.service.IActorService;

@Service
public class ActorServiceImpl implements IActorService{
	
	@Autowired
	private IActorRepository iActorRepository;
	
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
	public ResponseEntity<Actor> createActor(Actor actor) {
		System.out.println(actor);
		Actor savedActor = iActorRepository.save(actor);
		ResponseEntity<Actor> savedResponse = new ResponseEntity<>(savedActor, HttpStatus.CREATED);
		return savedResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteActor(Long actorId) {
		if (iActorRepository.existsById(actorId)) {
			logger.info("Actor by Id " + actorId + " exists. Deleting it..");
			if (iActorRepository.getMovieListByActor(actorId).isEmpty()) {
				logger.info("This actor has no associated movies.");
			} else {
				iActorRepository.deleteActorMoviesByActorId(actorId);
				logger.info("Deleted the movie mappings for this actor.");
			}
			iActorRepository.deleteMovieCast(actorId);
			return new ResponseEntity<>("Deleted actor " + actorId, HttpStatus.OK);
		} else {
			logger.info("Actor with id " + actorId + " was not found");
			return new ResponseEntity<>("Could not delete actor with Id: " + actorId, HttpStatus.OK);
		}
	}

}
