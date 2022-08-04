package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sethumaruthi.MovieReviewBlog.models.Studio;

public interface IStudioRepository extends JpaRepository<Studio, Long>{
	
	@Modifying
	@Query(value = "UPDATE public.movie SET movie_studio_studio_id=NULL WHERE movie_studio_studio_id=?1 ;", nativeQuery = true)
	int updateStudioMoviesByStudioId(Long studioId);
		
	@Query(value = "SELECT movie_id FROM public.movie WHERE movie_studio_studio_id=?1 ;", nativeQuery = true)
	List<Long> getMoviesByStudio(Long studioId);
	
}
