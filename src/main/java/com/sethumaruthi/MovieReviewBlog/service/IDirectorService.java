package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Director;

@Component
public interface IDirectorService {
	
	public ResponseEntity<Director> getDirector(Long directorId);
	
	public ResponseEntity<List<Director>> getAllDirectors();
	
	public ResponseEntity<Director> createDirector(Director director);

}
