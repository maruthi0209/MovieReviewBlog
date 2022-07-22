package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.Movie;
import com.sethumaruthi.MovieReviewBlog.repository.IMovieRepository;
import com.sethumaruthi.MovieReviewBlog.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private IMovieRepository iMovieRepository;

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
	public ResponseEntity<Movie> createMovie(Movie movie) {
		Movie savedMovie = iMovieRepository.save(movie);
		ResponseEntity<Movie> savedResponse = new ResponseEntity<Movie>(savedMovie, HttpStatus.CREATED);
		return savedResponse;
	}

}
