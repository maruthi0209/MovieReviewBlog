package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Director;

public interface IDirectorRepository extends JpaRepository<Director, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie WHERE movie_director_director_id = ?1 ;", nativeQuery = true)
	int deleteDirectorMovie(Long directorId);
}
