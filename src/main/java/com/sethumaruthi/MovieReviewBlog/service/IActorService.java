package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

@Component
public interface IActorService {
	
	public ResponseEntity<Actor> getActor(Long actorId);
	
	public ResponseEntity<List<Actor>> getAllActors();
	
	public ResponseEntity<String> createActor(Actor actor);
	
	public ResponseEntity<String> deleteActor(Long actorId);

}
