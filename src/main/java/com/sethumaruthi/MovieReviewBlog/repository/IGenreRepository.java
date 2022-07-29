package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sethumaruthi.MovieReviewBlog.models.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long>{
	
	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_genre WHERE movie_genre_genre_id = ?1 ;", nativeQuery = true)
	int deleteMovieGenre(Long genreId);
	
	@Modifying
	@Query(value = "INSERT INTO public.genre_genre_movies(genre_genre_id, genre_movies_movie_id) VALUES (:genreId, :movieId);", nativeQuery = true)
	int insertIntoGenreMovies(@Param("genreId") Long genreId, @Param("movieId") Long movieId);
	
	@Modifying
	@Query(value = "DELETE FROM public.genre_genre_movies WHERE genre_genre_id = ?1;", nativeQuery = true)
	int deleteFromGenreMoviesByGenreId(Long genreId);
	
	@Modifying
	@Query(value = "DELETE FROM public.genre_genre_movies WHERE genre_movies_movie_id = ?1;", nativeQuery = true)
	int deleteFromGenreMoviesByMovieId(Long movieId);
	
	@Query(value = "SELECT genre_genre_id, genre_movies_movie_id FROM public.genre_genre_movies WHERE genre_genre_id=?1 ;", nativeQuery = true)
	List<Long> getMoviesListByGenre(Long genreId);
	
	@Modifying
	@Query(value = "UPDATE public.genre_genre_movies SET genre_genre_id=?2, genre_movies_movie_id=?3 WHERE genre_genre_id=?1;", nativeQuery = true)
	int updateGenreMoviesByGenreId(Long oldGenreId, Long newGenreId, Long movieId);

	@Query(value = "UPDATE public.genre_genre_movies SET genre_genre_id=?3, genre_movies_movie_id=?2 WHERE genre_movies_movie_id=?1;", nativeQuery = true)
	int updateGenreMoviesByMovieId(Long oldMovieId, Long newMovieId, Long genreId);
}
