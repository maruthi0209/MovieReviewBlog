package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.Review;

@Component
public interface IReviewService {
	
	public ResponseEntity<Review> createReview(Review review);
	
	public ResponseEntity<Review> getReview(Long reviewId);
	
	public ResponseEntity<List<Review>> getAllReviews();
}
