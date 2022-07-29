package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sethumaruthi.MovieReviewBlog.models.Director;

public interface IDirectorRepository extends JpaRepository<Director, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie WHERE movie_director_director_id = ?1 ;", nativeQuery = true)
	int deleteDirectorMovie(Long directorId);
	
	@Modifying
	@Query(value = "INSERT INTO public.director_director_movies (director_director_id, director_movies_movie_id) VALUES (:directorId, :movieId);", nativeQuery = true)
	int insertIntoDirectorMovies(@Param("directorId") Long directorId, @Param("movieId") Long movieId);
	
	@Modifying
	@Query(value = "DELETE FROM public.director_director_movies WHERE director_director_id = ?1 ;", nativeQuery = true)
	int deleteFromDirectorMoviesByDirectorId(Long directorId);
	
	@Modifying
	@Query(value = "DELETE FROM public.director_director_movies WHERE director_movies_movie_id = ?1 ;", nativeQuery = true)
	int deleteFromDirectorMoviesActorId(Long actorId);
	
	@Query(value = "SELECT director_director_id, director_movies_movie_id FROM public.director_director_movies WHERE director_director_id = ?1 ;", nativeQuery = true)
	List<Long> getMoviesListByDirector(Long directorId);
	
	@Modifying
	@Query(value = "UPDATE public.director_director_movies SET director_director_id=?2 , director_movies_movie_id=?3 WHERE director_director_id=?1", nativeQuery = true)
	int updateDirectorMovieByDirectorId(Long oldDirectorId, Long newDirectorId, Long movieId);
	
	@Modifying
	@Query(value = "UPDATE public.director_director_movies SET director_director_id=?3 , director_movies_movie_id=?2 WHERE director_movies_movie_id=?1", nativeQuery = true)
	int updateDirectorMovieByMovieId(Long oldMovieId, Long newMovieId, Long directorId);
}
