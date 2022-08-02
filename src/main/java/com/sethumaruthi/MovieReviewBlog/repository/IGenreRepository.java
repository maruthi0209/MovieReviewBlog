package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sethumaruthi.MovieReviewBlog.models.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long>{
	
	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_genre WHERE movie_genre_genre_id = ?1;", nativeQuery = true)
	int deleteFromMovieGenresByGenreId(Long genreId);

	@Query(value = "SELECT movie_movie_id FROM public.movie_movie_genre WHERE movie_genre_genre_id=?1 ;", nativeQuery = true)
	List<Long> getMoviesListByGenre(Long genreId);

}
