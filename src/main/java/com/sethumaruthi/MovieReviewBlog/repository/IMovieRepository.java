package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Long>{
	
	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_cast	WHERE movie_movie_id = ?1 ;", nativeQuery = true)
	int deleteFromMovieCast(Long movieId);
	
	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_genre WHERE movie_movie_id = ?1 ;", nativeQuery = true)
	int deleteFromMovieGenre(Long movieId);
		
	@Modifying 
	@Query(value = "DELETE FROM public.review WHERE movie_movie_id = ?1 ;", nativeQuery = true)
	int deleteFromReview(Long movieId);	

}
