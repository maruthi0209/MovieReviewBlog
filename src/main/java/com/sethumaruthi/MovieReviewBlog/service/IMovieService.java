package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Movie;

@Component
public interface IMovieService {
	
	public ResponseEntity<Movie> getMovie(Long movieId);
	
	public ResponseEntity<List<Movie>> getAllMovies();
	
	public ResponseEntity<Movie> createMovie(Movie movie);

}
