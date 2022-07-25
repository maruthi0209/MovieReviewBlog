package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethumaruthi.MovieReviewBlog.models.ReviewUser;

public interface IUserRepository extends JpaRepository<ReviewUser, Long>{

}
