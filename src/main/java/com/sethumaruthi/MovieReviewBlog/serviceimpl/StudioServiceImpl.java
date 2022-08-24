package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.ArrayList;
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
import com.sethumaruthi.MovieReviewBlog.models.Studio;
import com.sethumaruthi.MovieReviewBlog.repository.IStudioRepository;
import com.sethumaruthi.MovieReviewBlog.service.IStudioService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateStudioEntities;

@Service
public class StudioServiceImpl implements IStudioService{
	
	@Autowired
	private IStudioRepository iStudioRepository;
	
	@Autowired
	private ValidateStudioEntities validateStudioEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(StudioServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Studio> getStudio(Long studioId) {
		logger.info("Fetching studio details with Id: %s".formatted(studioId));
		Studio studio = iStudioRepository.findById(studioId).orElseThrow(() -> new EntityNotFoundException("Studio with Id " + studioId + " was not found"));
		ResponseEntity<Studio> getResponse = new ResponseEntity<>(studio, HttpStatus.OK);
		logger.info("Successfully fetched the studio details.");
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Studio>> getAllStudios() {
		logger.info("Fetching details of all available studios");
		List<Studio> studiosList = new ArrayList<Studio>();
		studiosList = iStudioRepository.findAll();
		ResponseEntity<List<Studio>> listResponse = new ResponseEntity<>(studiosList, HttpStatus.OK);
		logger.info("Successfully fetched all studios' details");
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> createStudio(Studio studio) {
		List<String> validations = validateStudioEntities.validateStudio(studio);
		if (validations.size() == 0) {
			Studio savedStudio = iStudioRepository.save(studio);
			logger.info("Saved studio: " + savedStudio.toString());
			logger.info("Studio saved successfully.");
			return new ResponseEntity<>("Studio details saved successfully", HttpStatus.CREATED);
		} else {
			logger.info("Entered studio details failed validation check.");
			String respString = new String();
			for (int i = 0; i < validations.size(); i++) {
				respString = respString.concat(validations.get(i));
			}
			logger.info(respString);
			throw new ValidationException(respString);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteStudio(Long studioId) {
		if (iStudioRepository.existsById(studioId)) {
			logger.info("Studio by Id " + studioId + " exists. Deleting it..");
			if (iStudioRepository.getMoviesByStudio(studioId).isEmpty()) {
				logger.info("This studio has no associated movies.");
			} else {
				iStudioRepository.updateStudioMoviesByStudioId(studioId);
				logger.info("Deleted the movie mappings for this studio.");
			}
			iStudioRepository.deleteById(studioId);
			return new ResponseEntity<>("Deleted studio " + studioId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete studio with Id: " + studioId + ". Studio with id " + studioId + " was not found", HttpStatus.OK);
		}	
	}

}
