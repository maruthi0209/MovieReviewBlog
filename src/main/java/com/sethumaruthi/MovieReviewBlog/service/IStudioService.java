package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Studio;

@Component
public interface IStudioService {
	
	public ResponseEntity<Studio> getStudio(Long studioId);
	
	public ResponseEntity<List<Studio>> getAllStudios();
	
	public ResponseEntity<String> createStudio(Studio studio);
	
	public ResponseEntity<String> deleteStudio(Long studioId); 

}
