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

import com.sethumaruthi.MovieReviewBlog.models.Director;
import com.sethumaruthi.MovieReviewBlog.repository.IDirectorRepository;
import com.sethumaruthi.MovieReviewBlog.service.IDirectorService;

@Service
public class DirectorServiceImpl implements IDirectorService{
	
	@Autowired
	private IDirectorRepository iDirectorRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(DirectorServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Director> getDirector(Long directorId) {
		Director director = iDirectorRepository.findById(directorId).orElseThrow(() -> (new EntityNotFoundException("Director with id " + directorId + " was not found")));
		ResponseEntity<Director> getresponse = new ResponseEntity<>(director, HttpStatus.OK);
		return getresponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Director>> getAllDirectors() {
		List<Director> directorsList = new ArrayList<Director>();
		directorsList = iDirectorRepository.findAll();
		ResponseEntity<List<Director>> listresponse = new ResponseEntity<>(directorsList, HttpStatus.OK);
		return listresponse;
	}

	@Override
	@Transactional
	public ResponseEntity<Director> createDirector(Director director) {
		Director savedDirector = iDirectorRepository.save(director);
		ResponseEntity<Director> savedResponse = new ResponseEntity<>(savedDirector, HttpStatus.CREATED);
		return savedResponse;
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
