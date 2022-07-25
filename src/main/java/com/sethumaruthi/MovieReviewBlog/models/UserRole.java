package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	
	@Id
	@Column(name = "role_id", nullable = false)
	private Long roleId;
	
	@Column(name = "role_description", nullable = false)
	private String roleDescription;

	public UserRole() {
		super();
	}

	public UserRole(Long roleId, String roleDescription) {
		super();
		this.roleId = roleId;
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleDescription=" + roleDescription + "]";
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

}
