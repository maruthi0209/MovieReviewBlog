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
import com.sethumaruthi.MovieReviewBlog.models.Movie;
import com.sethumaruthi.MovieReviewBlog.service.IMovieService;

@Controller
@RequestMapping(value = "/movie")
public class MovieController {
	
	@Autowired
	private IMovieService iMovieService;
	
	@GetMapping(value = "/getMovie/{movieId}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
		return iMovieService.getMovie(movieId);
	}
	
	@GetMapping(value = "/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return iMovieService.getAllMovies();
	}
	
	@PostMapping(value = "/createMovie")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return iMovieService.createMovie(movie);
	}

	@DeleteMapping(value = "/deleteMovie/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
		return iMovieService.deleteMovie(movieId);
	}
}
