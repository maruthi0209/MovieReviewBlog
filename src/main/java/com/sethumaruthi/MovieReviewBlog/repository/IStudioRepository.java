package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Studio;

public interface IStudioRepository extends JpaRepository<Studio, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie WHERE movie_studio_studio_id = ?1 ;", nativeQuery = true)
	int deleteStudioMovie(Long studioId);
	
	@Modifying
	@Query(value = "INSERT INTO public.studio_studio_movies(studio_studio_id, studio_movies_movie_id) VALUES (?1, ?1);", nativeQuery = true)
	int insertIntoStudioMovies(Long studioId, Long movieid);
	
	@Modifying
	@Query(value = "DELETE FROM public.studio_studio_movies WHERE studio_studio_id=?1 ;", nativeQuery = true)
	int deleteFromStudioMoviesByStudioId(Long studioId);
	
	@Modifying 
	@Query(value = "DELETE FROM public.studio_studio_movies WHERE studio_movies_movie_id=?1 ;", nativeQuery = true)
	int deleteFromStudioMoviesByMovieId(Long movieId);
	
	@Query(value = "SELECT studio_studio_id, studio_movies_movie_id FROM public.studio_studio_movies WHERE studio_studio_id=?1 ;", nativeQuery = true)
	List<Long> getMoviesByStudio(Long studioId);
	
	@Modifying
	@Query(value = "UPDATE public.studio_studio_movies SET studio_studio_id=?2, studio_movies_movie_id=?3 WHERE studio_studio_id=?1;", nativeQuery = true)
	int updateStudioMoviesByStudioId(Long oldStudioId, Long newStudioId, Long movieId);
	
	@Modifying
	@Query(value = "UPDATE public.studio_studio_movies SET studio_studio_id=?3, studio_movies_movie_id=?2 WHERE studio_movies_movie_id=?1;", nativeQuery = true)
	int updateStudioMoviesByMovieId(Long oldMovieId, Long newMovieId, Long studioId);
}
