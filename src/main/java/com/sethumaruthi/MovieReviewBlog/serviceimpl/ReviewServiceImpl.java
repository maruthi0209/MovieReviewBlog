package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.exception.ValidationException;
import com.sethumaruthi.MovieReviewBlog.models.Review;
import com.sethumaruthi.MovieReviewBlog.repository.IReviewRepository;
import com.sethumaruthi.MovieReviewBlog.service.IReviewService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateReviewEntities;

@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	private IReviewRepository iReviewRepository;
	
	@Autowired
	private ValidateReviewEntities validateReviewEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(ValidateReviewEntities.class);
	
	@Override
	@Transactional
	public ResponseEntity<String> createReview(Review review) {
		List<String> validations = validateReviewEntities.validateReview(review);
		if (validations.size() == 0) {
			Review savedReview = iReviewRepository.save(review);
			logger.info("Saved review: " + savedReview.toString());
			logger.info("Movie review saved successfully.");
			return new ResponseEntity<>("Movie review saved successfully.", HttpStatus.CREATED);
		} else {
			String respString = new String();
			for (int i = 0; i < validations.size(); i ++) {
				respString = respString.concat(validations.get(i));
			}
			throw new ValidationException(respString);
		}
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
