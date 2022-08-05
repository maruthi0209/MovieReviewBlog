package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sethumaruthi.MovieReviewBlog.models.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{

	@Query(value = "SELECT user_id FROM public.app_user WHERE user_role_role_id=?1 ;", nativeQuery = true)
	List<Long> getUsersFromRoleId(Long roleId);
	
	@Modifying
	@Query(value = "UPDATE public.app_user SET user_role_role_id=NULL WHERE user_role_role_id=?1 ;", nativeQuery = true)
	int updateRoleUsersByRoleId(Long roleId);
	
}
