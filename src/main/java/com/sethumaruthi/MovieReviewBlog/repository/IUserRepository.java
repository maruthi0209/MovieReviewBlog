package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sethumaruthi.MovieReviewBlog.models.AppUser;

public interface IUserRepository extends JpaRepository<AppUser, Long>{
	
	@Modifying
	@Query(value = "INSERT INTO public.app_user_reviews_list(app_user_user_id, reviews_list_review_id) VALUES (:userId, :reviewId);", nativeQuery=true)
	int insertIntoUserReviews(@Param("userId") Long userId, @Param("reviewId") Long reviewId);
	
	@Modifying
	@Query(value = "DELETE FROM public.app_user_reviews_list WHERE app_user_user_id=?1 ;", nativeQuery=true)
	int deleteFromUserReviewsByUserId(Long userId);

	@Modifying
	@Query(value = "DELETE FROM public.app_user_reviews_list WHERE review_list_review_id=?1 ;", nativeQuery=true)
	int deleteFromUsersReviewsByReviewId(Long reviewId);
	
	@Query(value = "SELECT app_user_user_id, reviews_list_review_id FROM public.app_user_reviews_list WHERE app_user_user_id=?1 ;", nativeQuery = true)
	int getReviewsFromUserId(Long userId);
	
	@Modifying
	@Query(value = "UPDATE public.app_user_reviews_list SET app_user_user_id=?2, reviews_list_review_id=?3 WHERE app_user_user_id=?1 ;", nativeQuery=true)
	int updateUserReviewsByUserId(Long oldUserId, Long newUserId, Long reviewId);
	
	@Modifying
	@Query(value = "UPDATE public.app_user_reviews_list SET app_user_user_id=?3, reviews_list_review_id=?2 WHERE review_list_review_id=?1 ;", nativeQuery=true)
	int updateUserReviewsByReviewId(Long oldReviewId, Long newReviewId, Long userId);
}
