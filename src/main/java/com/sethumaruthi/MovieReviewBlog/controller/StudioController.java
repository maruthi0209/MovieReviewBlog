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

import com.sethumaruthi.MovieReviewBlog.models.Studio;
import com.sethumaruthi.MovieReviewBlog.service.IStudioService;

@Controller
@RequestMapping(value = "/studio")
public class StudioController {
	
	@Autowired
	private IStudioService iStudioService;
	
	@GetMapping(value = "/getStudio/{studioId}")
	public ResponseEntity<Studio> getStudio(@PathVariable Long studioId) {
		return iStudioService.getStudio(studioId);
	}
	
	@GetMapping(value = "/getAllStudios")
	public ResponseEntity<List<Studio>> getAllStudios(){
		return iStudioService.getAllStudios();
	}
	
	@PostMapping(value = "/createStudio")
	public ResponseEntity<String> createStudio(@RequestBody Studio studio) {
		return iStudioService.createStudio(studio);
	}
	
	@DeleteMapping(value = "/deleteStudio/{studioId}")
	public ResponseEntity<String> deleteStudio(@PathVariable Long studioId) {
		return iStudioService.deleteStudio(studioId);
	}
}
