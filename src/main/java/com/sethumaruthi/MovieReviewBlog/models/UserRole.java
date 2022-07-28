package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class UserRole {
	
	@Id
	@Column(name = "role_id", nullable = false)
	private Long roleId;
	
	@Column(name = "role_description", nullable = false)
	private String roleDescription;
	
	@OneToMany
	private List<AppUser> users;

	public UserRole() {
		super();
	}

	public UserRole(Long roleId, String roleDescription, List<AppUser> users) {
		super();
		this.roleId = roleId;
		this.roleDescription = roleDescription;
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleDescription=" + roleDescription + ", users=" + users + "]";
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public List<AppUser> getUsers() {
		return users;
	}

	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	

}
