package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.Studio;
import com.sethumaruthi.MovieReviewBlog.repository.IStudioRepository;
import com.sethumaruthi.MovieReviewBlog.service.IStudioService;

@Service
public class StudioServiceImpl implements IStudioService{
	
	@Autowired
	private IStudioRepository iStudioRepository;

	@Override
	@Transactional
	public ResponseEntity<Studio> getStudio(Long studioId) {
		Studio studio = iStudioRepository.findById(studioId).orElseThrow(() -> new EntityNotFoundException("Studio with Id " + studioId + " was not found"));
		ResponseEntity<Studio> getResponse = new ResponseEntity<>(studio, HttpStatus.OK);
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Studio>> getAllStudios() {
		List<Studio> studiosList = new ArrayList<Studio>();
		studiosList = iStudioRepository.findAll();
		ResponseEntity<List<Studio>> listResponse = new ResponseEntity<>(studiosList, HttpStatus.OK);
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<Studio> createStudio(Studio studio) {
		Studio savedStudio = iStudioRepository.save(studio);
		ResponseEntity<Studio> savedResponse = new ResponseEntity<>(savedStudio, HttpStatus.CREATED);
		return savedResponse;
	}

}
