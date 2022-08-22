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
import com.sethumaruthi.MovieReviewBlog.models.Movie;
import com.sethumaruthi.MovieReviewBlog.repository.IMovieRepository;
import com.sethumaruthi.MovieReviewBlog.service.IMovieService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateMovieEntities;

@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private IMovieRepository iMovieRepository;
	
	@Autowired
	private ValidateMovieEntities validateMovieEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Movie> getMovie(Long movieId) {
		Movie movie = iMovieRepository.findById(movieId).orElseThrow(()-> new EntityNotFoundException("Movie with id " + movieId + " was not found"));
		ResponseEntity<Movie> getResponse = new ResponseEntity<>(movie, HttpStatus.OK);
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> moviesList = iMovieRepository.findAll();
		ResponseEntity<List<Movie>> listResponse = new ResponseEntity<>(moviesList, HttpStatus.OK);
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> createMovie(Movie movie) {
		List<String> validations = validateMovieEntities.validateMovie(movie);
		if (validations.size() == 0) {
			Movie savedMovie = iMovieRepository.save(movie);
			logger.info("Saved movie: " + savedMovie.toString());
			logger.info("Movie details saved successfully.");
			return new ResponseEntity<>("Movie details saved successfully.", HttpStatus.CREATED);
		} else {
			String respString = new String();
			for (int i = 0; i < validations.size(); i++) {
				respString = respString.concat(validations.get(i));
			}
			throw new ValidationException(respString);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteMovie(Long movieId) {
		if (iMovieRepository.existsById(movieId)) {
			logger.info("Movie by Id " + movieId + " exists. Deleting it..");
			logger.info("Deleting associated actors data.");
			deleteMovieAssociatedTablesData(movieId);
			logger.info("Deleted associated tables data.");
			iMovieRepository.deleteById(movieId);
			return new ResponseEntity<>("Deleted movie " + movieId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete movie with Id: " + movieId + ". Movie with id " + movieId + " was not found", HttpStatus.OK);
		}
	}
	
	@Transactional
	private void deleteMovieAssociatedTablesData(Long movieId) {
		logger.info("Deleting data from Movie Actors table.");
		iMovieRepository.deleteFromMovieCast(movieId);
		logger.info("Deleted data from Movie Actors table.");
		logger.info("Deleting data from Movie Genre table.");
		iMovieRepository.deleteFromMovieGenre(movieId);
		logger.info("Deleted data from Movie Genre table.");
		logger.info("Deleting data from Movie review table.");
		iMovieRepository.deleteFromReview(movieId);
		logger.info("Deleted data from Movie review table.");

	}

}
