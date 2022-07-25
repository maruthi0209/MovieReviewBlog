package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.Review;
import com.sethumaruthi.MovieReviewBlog.repository.IReviewRepository;
import com.sethumaruthi.MovieReviewBlog.service.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	private IReviewRepository iReviewRepository;
	
	@Override
	@Transactional
	public ResponseEntity<Review> createReview(Review review) {
		Review savedReview = iReviewRepository.save(review);
		ResponseEntity<Review> savedResponse = new ResponseEntity<>(savedReview, HttpStatus.CREATED);
		return savedResponse;
	}
	
	@Override
	@Transactional
	public ResponseEntity<Review> getReview(Long reviewId) {
		Review review = iReviewRepository.findById(reviewId).orElseThrow(() -> new EntityNotFoundException("Review with Id " + reviewId + " was not found"));
		ResponseEntity<Review> getReview = new ResponseEntity<>(review, HttpStatus.OK);
		return getReview;
	}
	
	@Override
	@Transactional 
	public ResponseEntity<List<Review>> getAllReviews() {
		List<Review> reviewsList = iReviewRepository.findAll();
		ResponseEntity<List<Review>> listResponse = new ResponseEntity<List<Review>>(reviewsList, HttpStatus.OK);
		return listResponse;
	}
}
