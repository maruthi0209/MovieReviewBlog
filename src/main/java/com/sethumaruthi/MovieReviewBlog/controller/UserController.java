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

import com.sethumaruthi.MovieReviewBlog.models.ReviewUser;
import com.sethumaruthi.MovieReviewBlog.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<ReviewUser> createUser(@RequestBody ReviewUser user) {
		return iUserService.createUser(user);
	}
	
	@GetMapping(value = "/getUser/{userId}")
	public ResponseEntity<ReviewUser> getUser(@PathVariable Long userId){
		return iUserService.getUser(userId);
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<ReviewUser>> getAllUsers() {
		return iUserService.getAllUsers();
	}
}
