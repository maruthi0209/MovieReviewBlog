package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long>{

}
