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

import com.sethumaruthi.MovieReviewBlog.models.Movie;
import com.sethumaruthi.MovieReviewBlog.repository.IMovieRepository;
import com.sethumaruthi.MovieReviewBlog.service.IMovieService;
import com.sethumaruthi.MovieReviewBlog.util.ValidateMovieEntities;

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
		if (validateMovieEntities.validateMovie(movie)) {
			Movie savedMovie = iMovieRepository.save(movie);
			logger.info("Saved movie: " + savedMovie.toString());
			logger.info("Movie details saved successfully.");
			return new ResponseEntity<>("Movie details saved successfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Movie details failed validation check. Enter valid details.", HttpStatus.CREATED);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteMovie(Long movieId) {
		if (iMovieRepository.existsById(movieId)) {
			logger.info("Movie by Id " + movieId + " exists. Deleting it..");
			logger.info("Deleting associated tables data.");
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
	}

}
