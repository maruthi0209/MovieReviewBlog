package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;
import com.sethumaruthi.MovieReviewBlog.repository.IUserRepository;
import com.sethumaruthi.MovieReviewBlog.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	@Transactional
	public ResponseEntity<AppUser> createUser(AppUser user) {
		AppUser savedUser = iUserRepository.save(user);
		ResponseEntity<AppUser> savedResponse = new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		return savedResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<AppUser> getUser(Long userId) {
		AppUser user = iUserRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User with username " + userId + " was not found"));
		ResponseEntity<AppUser> getResponse = new ResponseEntity<>(user, HttpStatus.OK);
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<AppUser>> getAllUsers() {
		List<AppUser> usersList = iUserRepository.findAll();
		ResponseEntity<List<AppUser>> listResponse = new ResponseEntity<>(usersList, HttpStatus.OK);
		return listResponse;
	}

}
