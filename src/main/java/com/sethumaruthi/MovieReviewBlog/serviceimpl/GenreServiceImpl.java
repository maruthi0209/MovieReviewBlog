package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.Genre;
import com.sethumaruthi.MovieReviewBlog.repository.IGenreRepository;
import com.sethumaruthi.MovieReviewBlog.service.IGenreService;

@Service
public class GenreServiceImpl implements IGenreService{
	
	@Autowired
	private IGenreRepository iGenreRepository;

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

}
