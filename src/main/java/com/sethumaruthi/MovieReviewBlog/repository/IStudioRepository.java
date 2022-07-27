package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Studio;

public interface IStudioRepository extends JpaRepository<Studio, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie WHERE movie_studio_studio_id = ?1 ;", nativeQuery = true)
	int deleteStudioMovie(Long studioId);
}
