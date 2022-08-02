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

import com.sethumaruthi.MovieReviewBlog.models.Genre;
import com.sethumaruthi.MovieReviewBlog.repository.IDirectorRepository;
import com.sethumaruthi.MovieReviewBlog.repository.IGenreRepository;
import com.sethumaruthi.MovieReviewBlog.service.IGenreService;

@Service
public class GenreServiceImpl implements IGenreService{
	
	@Autowired
	private IGenreRepository iGenreRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<Genre> getGenre(Long genreId) {
		Genre genre = iGenreRepository.findById(genreId).orElseThrow(() -> new EntityNotFoundException("Genre with Id " + genreId + " was not found"));
		ResponseEntity<Genre> getResponse = new ResponseEntity<>(genre, HttpStatus.OK);
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Genre>> getAllGenres() {
		List<Genre> genresList = new ArrayList<Genre>();
		genresList = iGenreRepository.findAll();
		ResponseEntity<List<Genre>> listResponse = new ResponseEntity<>(genresList, HttpStatus.OK);
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<Genre> createGenre(Genre genre) {
		Genre savedGenre = iGenreRepository.save(genre);
		ResponseEntity<Genre> savedResponse = new ResponseEntity<Genre>(savedGenre, HttpStatus.CREATED);
		return savedResponse;
	}

	@Override
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
			return new ResponseEntity<>("Could not delete actor with Id: " + genreId + ". Genre with id " + genreId + " was not found", HttpStatus.OK);
		}
	}

}
