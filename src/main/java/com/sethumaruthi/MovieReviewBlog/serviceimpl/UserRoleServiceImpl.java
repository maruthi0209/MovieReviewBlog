package com.sethumaruthi.MovieReviewBlog.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;
import com.sethumaruthi.MovieReviewBlog.repository.IUserRoleRepository;
import com.sethumaruthi.MovieReviewBlog.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
	
	@Autowired
	private IUserRoleRepository iUserRoleRepository;

	@Override
	@Transactional
	public ResponseEntity<UserRole> createRole(UserRole role) {
		UserRole savedRole = iUserRoleRepository.save(role);
		ResponseEntity<UserRole> savedResponse = new ResponseEntity<>(savedRole, HttpStatus.CREATED);
		return savedResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<UserRole> getRole(Long roleId) {
		UserRole role = iUserRoleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role with Id " + roleId + " was not found"));
		ResponseEntity<UserRole> getResponse = new ResponseEntity<>(role, HttpStatus.OK);
		return getResponse;
	}

	@Override
	@Transactional
	public ResponseEntity<List<UserRole>> getAllRoles() {
		List<UserRole> rolesList = iUserRoleRepository.findAll();
		ResponseEntity<List<UserRole>> listResponse = new ResponseEntity<>(rolesList, HttpStatus.OK);
		return listResponse;
	}

}
