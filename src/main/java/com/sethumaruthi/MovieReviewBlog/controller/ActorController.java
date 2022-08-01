package com.sethumaruthi.MovieReviewBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sethumaruthi.MovieReviewBlog.models.Actor;
import com.sethumaruthi.MovieReviewBlog.service.IActorService;

@Controller
@RequestMapping(value = "/actor")
public class ActorController {
	
	@Autowired
	private IActorService iActorService;
	
	@PostMapping(value = "/createActor")
	public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
		return iActorService.createActor(actor);
	}
	
	@GetMapping(value = "/getActor/{actorId}")
	public ResponseEntity<Actor> getActor(@PathVariable Long actorId) {
		return iActorService.getActor(actorId);
	}
	
	@GetMapping(value = "/getAllActors")
	public ResponseEntity<List<Actor>> getAllActors() {
		return iActorService.getAllActors();
		
	}
	
	@DeleteMapping(value = "/deleteActor/{actorId}")
	public ResponseEntity<String> deleteActor(@PathVariable Long actorId) {
		return iActorService.deleteActor(actorId);
	}

}
