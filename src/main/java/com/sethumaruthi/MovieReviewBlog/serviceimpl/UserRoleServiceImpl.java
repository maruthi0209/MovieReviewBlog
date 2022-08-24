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
import com.sethumaruthi.MovieReviewBlog.models.UserRole;
import com.sethumaruthi.MovieReviewBlog.repository.IUserRoleRepository;
import com.sethumaruthi.MovieReviewBlog.service.IUserRoleService;
import com.sethumaruthi.MovieReviewBlog.validations.ValidateUserRoleEntities;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
	
	@Autowired
	private IUserRoleRepository iUserRoleRepository;
	
	@Autowired
	private ValidateUserRoleEntities validateUserRoleEntities;
	
	public static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Override
	@Transactional
	public ResponseEntity<String> createRole(UserRole role) {
		List<String> validations = validateUserRoleEntities.validateUserRole(role);
		if (validations.size() == 0) {
			UserRole savedRole = iUserRoleRepository.save(role);
			logger.info("Saved role: " + savedRole.toString());
			logger.info("User Role saved successfully.");
			return new ResponseEntity<>("User Role details saved successfully.", HttpStatus.CREATED);
		} else {
			logger.info("Entered role details failed validation check.");
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
	public ResponseEntity<UserRole> getRole(Long roleId) {
		logger.info("Fetching role details with Id: %s".formatted(roleId));
		UserRole role = iUserRoleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role with Id " + roleId + " was not found"));
		ResponseEntity<UserRole> getResponse = new ResponseEntity<>(role, HttpStatus.OK);
		logger.info("Successfully fetched the role details.");
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<UserRole>> getAllRoles() {
		logger.info("Fetching details of all available roles ");
		List<UserRole> rolesList = iUserRoleRepository.findAll();
		ResponseEntity<List<UserRole>> listResponse = new ResponseEntity<>(rolesList, HttpStatus.OK);
		logger.info("Successfully fetched all roles' details.");
		return listResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteRole(Long roleId) {
		if (iUserRoleRepository.existsById(roleId)) {
			logger.info("Role by Id " + roleId + " exists. Deleting it..");
			if (iUserRoleRepository.getUsersFromRoleId(roleId).isEmpty()) {
				logger.info("This Role has no associated movies.");
			} else {
				iUserRoleRepository.updateRoleUsersByRoleId(roleId);
				logger.info("Deleted the user mappings for this role.");
			}
			iUserRoleRepository.deleteById(roleId);
			return new ResponseEntity<>("Deleted studio " + roleId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Could not delete role with Id: " + roleId + ". Role with id " + roleId + " was not found", HttpStatus.OK);
		}
	}

}
