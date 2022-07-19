package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long>{

}
