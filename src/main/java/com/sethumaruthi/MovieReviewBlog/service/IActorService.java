package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

@Component
public interface IActorService {
	
	public ResponseEntity<Object> getActor(Long actorId);
	
	public ResponseEntity<List<Actor>> getAllActors();
	
	public ResponseEntity<Actor> createActor(Actor actor);

}
