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
import com.sethumaruthi.MovieReviewBlog.models.Director;
import com.sethumaruthi.MovieReviewBlog.repository.IDirectorRepository;
import com.sethumaruthi.MovieReviewBlog.service.IDirectorService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateDirectorEntities;

@Service
public class DirectorServiceImpl implements IDirectorService{
	
	@Autowired
	private IDirectorRepository iDirectorRepository;
	
	@Autowired
	private ValidateDirectorEntities validateDirectorEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(DirectorServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Director> getDirector(Long directorId) {
		logger.info("Fetching director details with Id: %s".formatted(directorId));
		Director director = iDirectorRepository.findById(directorId).orElseThrow(() -> (new EntityNotFoundException("Director with id " + directorId + " was not found")));
		ResponseEntity<Director> getresponse = new ResponseEntity<>(director, HttpStatus.OK);
		logger.info("Successfully fetched director details.");
		return getresponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Director>> getAllDirectors() {
		logger.info("Fetching details of all available actors.");
		List<Director> directorsList = new ArrayList<Director>();
		directorsList = iDirectorRepository.findAll();
		ResponseEntity<List<Director>> listresponse = new ResponseEntity<>(directorsList, HttpStatus.OK);
		logger.info("Successfully fetched all directors' details.");
		return listresponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> createDirector(Director director) {
		List<String> validations = validateDirectorEntities.validateDirector(director);
		if (validations.size() == 0) {
			Director savedDirector = iDirectorRepository.save(director);
			logger.info("Saved director: " + savedDirector.toString());
			logger.info("Director saved successfully.");
			return new ResponseEntity<>("Director details saved successfully.", HttpStatus.CREATED);
		} else {
			logger.info("Entered director details failed validation check.");
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
	public ResponseEntity<String> deleteDirector(Long directorId) {
		if (iDirectorRepository.existsById(directorId)) {
			logger.info("Director by Id " + directorId + " exists. Deleting it.");
			if (iDirectorRepository.getMoviesListByDirector(directorId).isEmpty()) {
				logger.info("This director has no associated movies.");
			} else {
				iDirectorRepository.deleteFromDirectorMoviesByDirectorId(directorId);
				logger.info("Deleted the movie mappings for this director.");
			}
			iDirectorRepository.deleteById(directorId);
			return new ResponseEntity<>("Deleted director " + directorId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete director with Id: " + directorId + ". Director with id " + directorId + " was not found", HttpStatus.OK);
		}
	}

}
