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

import com.sethumaruthi.MovieReviewBlog.models.AppUser;
import com.sethumaruthi.MovieReviewBlog.repository.IUserRepository;
import com.sethumaruthi.MovieReviewBlog.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository iUserRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(StudioServiceImpl.class);

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

	@Override
	@Transactional
	public ResponseEntity<String> deleteUser(Long userId) {
		if (iUserRepository.existsById(userId)) {
			logger.info("User by Id " + userId + " exists. Deleting it..");
			if (iUserRepository.getReviewsFromUserId(userId).isEmpty()) {
				logger.info("This user has no associated reviews.");
			} else {
				iUserRepository.updateUserReviewsByUserId(userId);
				logger.info("Deleted the review mappings for this user.");
			}
			iUserRepository.deleteById(userId);
			return new ResponseEntity<>("Deleted user " + userId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete user with Id: " + userId + ". Review with id " + userId + " was not found", HttpStatus.OK);
		}
	}

}
