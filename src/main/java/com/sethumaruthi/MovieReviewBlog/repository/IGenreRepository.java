package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long>{
	
	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_genre WHERE movie_genre_genre_id = ?1 ;", nativeQuery = true)
	int deleteMovieGenre(Long genreId);

}
