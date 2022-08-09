package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;

@Component
public interface IUserService {
	
	public ResponseEntity<String> createUser(AppUser user);
	
	public ResponseEntity<AppUser> getUser(Long userId);
	
	public ResponseEntity<List<AppUser>> getAllUsers();
	
	public ResponseEntity<String> deleteUser(Long userId);

}
