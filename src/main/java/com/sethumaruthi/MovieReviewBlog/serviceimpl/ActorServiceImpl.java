package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

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

	@Override
	@Transactional
	public ResponseEntity<Actor> getActor(Long actorId) {
			Actor actor = iActorRepository.findById(actorId).orElseThrow(()-> new EntityNotFoundException("Actor with id " + actorId + " was not found"));
			ResponseEntity<Actor> getResponse = new ResponseEntity<>(actor, HttpStatus.OK);
			return getResponse;
	}

	@Override
	public ResponseEntity<List<Actor>> getAllActors() {
		List<Actor> actorsList = new ArrayList<Actor>();
		actorsList = iActorRepository.findAll();
		ResponseEntity<List<Actor>> listResponse = new ResponseEntity<>(actorsList, HttpStatus.OK);
		return listResponse;
	}

	@Override
	public ResponseEntity<Actor> createActor(Actor actor) {
		Actor savedActor = iActorRepository.save(actor);
		ResponseEntity<Actor> savedResponse = new ResponseEntity<>(savedActor, HttpStatus.CREATED);
		return savedResponse;
	}

}
