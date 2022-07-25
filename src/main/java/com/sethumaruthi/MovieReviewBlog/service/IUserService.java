package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.ReviewUser;

@Component
public interface IUserService {
	
	public ResponseEntity<ReviewUser> createUser(ReviewUser user);
	
	public ResponseEntity<ReviewUser> getUser(Long userId);
	
	public ResponseEntity<List<ReviewUser>> getAllUsers();

}
