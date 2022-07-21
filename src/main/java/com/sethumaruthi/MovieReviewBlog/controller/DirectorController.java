package com.sethumaruthi.MovieReviewBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sethumaruthi.MovieReviewBlog.models.Director;
import com.sethumaruthi.MovieReviewBlog.service.IDirectorService;

@Controller
@RequestMapping(value = "/director")
public class DirectorController {
	
	@Autowired
	private IDirectorService iDirectorService;
	
	@GetMapping(value = "/getDirector/{directorId}")
	public ResponseEntity<Director> getDirector(@PathVariable Long directorId) {
		return iDirectorService.getDirector(directorId);
	}

	@GetMapping(value = "/getAllDirectors")
	public ResponseEntity<List<Director>> getAllDirectors() {
		return iDirectorService.getAllDirectors();
	}
	
	@PostMapping(value = "/createDirector")
	public ResponseEntity<Director> createDirector(Director director) {
		return iDirectorService.createDirector(director);
	}
}
