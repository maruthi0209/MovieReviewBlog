package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

@Component
public interface IGenreService {
	
	public ResponseEntity<Genre> getGenre(Long genreId);
	
	public ResponseEntity<List<Genre>> getAllGenres();
	
	public ResponseEntity<Genre> createGenre(Genre genre);

}
