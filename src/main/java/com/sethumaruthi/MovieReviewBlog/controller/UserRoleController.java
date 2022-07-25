package com.sethumaruthi.MovieReviewBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;
import com.sethumaruthi.MovieReviewBlog.service.IUserRoleService;

@Controller
@RequestMapping(value = "/userRole")
public class UserRoleController {
	
	@Autowired
	private IUserRoleService iUserRoleService;
	
	@PostMapping(value = "/createRole")
	public ResponseEntity<UserRole> createRole(@RequestBody UserRole userRole) {
		return iUserRoleService.createRole(userRole);
	}
	
	@GetMapping(value ="/getRole/{roleId}")
	public ResponseEntity<UserRole> getRole(@PathVariable Long roleId) {
		return iUserRoleService.getRole(roleId);
	}
	
	@GetMapping(value = "/getAllRoles")
	public ResponseEntity<List<UserRole>> getAllRoles() {
		return iUserRoleService.getAllRoles();
	}
	

}
