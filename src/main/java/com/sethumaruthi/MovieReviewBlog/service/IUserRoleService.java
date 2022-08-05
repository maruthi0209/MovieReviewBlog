package com.sethumaruthi.MovieReviewBlog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;

@Component
public interface IUserRoleService {
	
	public ResponseEntity<UserRole> createRole(UserRole role);
	
	public ResponseEntity<UserRole> getRole(Long roleId);
	
	public ResponseEntity<List<UserRole>> getAllRoles();
	
	public ResponseEntity<String> deleteRole(Long roleId);

}
