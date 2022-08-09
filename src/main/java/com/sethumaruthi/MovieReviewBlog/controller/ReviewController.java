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

import com.sethumaruthi.MovieReviewBlog.models.Review;
import com.sethumaruthi.MovieReviewBlog.service.IReviewService;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	@Autowired
	private IReviewService iReviewService;
	
	@PostMapping(value = "/createReview")
	public ResponseEntity<String> createReview(@RequestBody Review review) {
		return iReviewService.createReview(review);
	}

	@GetMapping(value = "/getReview/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
		return iReviewService.getReview(reviewId);
	}
	
	@GetMapping(value = "getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews(){
		return iReviewService.getAllReviews();
	}
	
}
