package com.sethumaruthi.MovieReviewBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sethumaruthi.MovieReviewBlog.models.Genre;
import com.sethumaruthi.MovieReviewBlog.service.IGenreService;

@Controller
@RequestMapping(value = "/genre")
public class GenreController {

	@Autowired
	private IGenreService iGenreService;
	
	@GetMapping(value = "/getGenre/{genreId}")
	public ResponseEntity<Genre> getGenre(@PathVariable Long genreId) {
		return iGenreService.getGenre(genreId);
	}
	
	@GetMapping(value = "/getAllGenres")
	public ResponseEntity<List<Genre>> getAllGenres() {
		return iGenreService.getAllGenres();
	}
	
	@PostMapping(value = "/createGenre")
	public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
		return iGenreService.createGenre(genre);
	}
}
