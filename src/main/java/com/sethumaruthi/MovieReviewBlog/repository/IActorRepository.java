package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_cast WHERE movie_cast_actor_id = ?1 ;", nativeQuery = true)
	int deleteMovieCast(Long actorId);

}
