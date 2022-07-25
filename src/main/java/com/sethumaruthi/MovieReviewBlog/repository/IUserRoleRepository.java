package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{

}
