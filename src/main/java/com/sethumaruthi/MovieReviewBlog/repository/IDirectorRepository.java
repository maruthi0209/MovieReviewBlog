package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sethumaruthi.MovieReviewBlog.models.Director;

public interface IDirectorRepository extends JpaRepository<Director, Long>{
		
	@Modifying
	@Query(value = "UPDATE public.movie SET movie_director_director_id=NULL WHERE movie_director_director_id=?1 ;", nativeQuery = true)
	int deleteFromDirectorMoviesByDirectorId(Long directorId);
		
	@Query(value = "SELECT movie_id FROM public.movie WHERE movie_director_director_id = ?1 ;", nativeQuery = true)
	List<Long> getMoviesListByDirector(Long directorId);

}
