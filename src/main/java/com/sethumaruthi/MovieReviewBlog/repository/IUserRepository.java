package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sethumaruthi.MovieReviewBlog.models.AppUser;

public interface IUserRepository extends JpaRepository<AppUser, Long>{
	
	@Query(value = "SELECT review_id FROM public.review WHERE user_user_id=?1 ;", nativeQuery = true)
	List<Long> getReviewsFromUserId(Long userId);
	
	@Modifying
	@Query(value = "UPDATE public.review SET user_user_id=NULL WHERE user_user_id=?1 ;", nativeQuery=true)
	int updateUserReviewsByUserId(Long userId);
	
}
