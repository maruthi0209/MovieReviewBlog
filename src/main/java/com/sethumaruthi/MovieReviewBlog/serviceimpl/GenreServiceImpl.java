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
import com.sethumaruthi.MovieReviewBlog.models.Genre;
import com.sethumaruthi.MovieReviewBlog.repository.IGenreRepository;
import com.sethumaruthi.MovieReviewBlog.service.IGenreService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateGenreEntities;

@Service
public class GenreServiceImpl implements IGenreService{
	
	@Autowired
	private IGenreRepository iGenreRepository;
	
	@Autowired
	private ValidateGenreEntities validateGenreEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Genre> getGenre(Long genreId) {
		logger.info("Fetching genre details with Id: %s".formatted(genreId));
		Genre genre = iGenreRepository.findById(genreId).orElseThrow(() -> new EntityNotFoundException("Genre with Id " + genreId + " was not found"));
		ResponseEntity<Genre> getResponse = new ResponseEntity<>(genre, HttpStatus.OK);
		logger.info("Successfully fetched genre details.");
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Genre>> getAllGenres() {
		logger.info("Fetching details of all available genres.");
		List<Genre> genresList = new ArrayList<Genre>();
		genresList = iGenreRepository.findAll();
		ResponseEntity<List<Genre>> listResponse = new ResponseEntity<>(genresList, HttpStatus.OK);
		logger.info("Successfully fetched all genres' details.");
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> createGenre(Genre genre) {
		List<String> validations = validateGenreEntities.validateGenre(genre);
		if (validations.size() == 0) {
			Genre savedGenre = iGenreRepository.save(genre);
			logger.info("Saved genre: " + savedGenre.toString());
			logger.info("Genre saved successfully.");
			return new ResponseEntity<>("Genre details saved successfully.", HttpStatus.CREATED);
		} else {
			logger.info("Entered genre details failed validation check.");
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
	public ResponseEntity<String> deleteGenre(Long genreId) {
		if (iGenreRepository.existsById(genreId)) {
			logger.info("Genre by Id " + genreId + " exists. Deleting it..");
			if (iGenreRepository.getMoviesListByGenre(genreId).isEmpty()) {
				logger.info("This genre has no associated movies.");
			} else {
				iGenreRepository.deleteFromMovieGenresByGenreId(genreId);
				logger.info("Deleted the movie mappings for this genre.");
			}
			iGenreRepository.deleteById(genreId);
			return new ResponseEntity<>("Deleted genre " + genreId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete genre with Id: " + genreId + ". Genre with id " + genreId + " was not found", HttpStatus.OK);
		}
	}

}
