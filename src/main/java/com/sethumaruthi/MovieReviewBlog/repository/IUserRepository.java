package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;

public interface IUserRepository extends JpaRepository<AppUser, Long>{

}
