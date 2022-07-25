package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@Entity
@Table(name = "review_user", uniqueConstraints={@UniqueConstraint(columnNames = {"user_id" , "user_email"})})
public class ReviewUser {
	
	@Id
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Email
	@Column(name = "user_email", nullable = false )
	private String userEmail;
	
	@Column(name = "user_password", nullable = false)
	private String userPassword;
	
	@ManyToOne
	private UserRole userRole;

	public ReviewUser() {
		super();
	}

	public ReviewUser(Long userId, @Email String userEmail, String userPassword, UserRole userRole) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "ReviewUser [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userRole=" + userRole + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String user) {
		this.userPassword = user;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
