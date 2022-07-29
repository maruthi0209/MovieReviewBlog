package com.sethumaruthi.MovieReviewBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sethumaruthi.MovieReviewBlog.models.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{
	
	@Modifying
	@Query(value = "INSERT INTO public.role_users(user_role_role_id, users_user_id) VALUES (:roleId, :userId);", nativeQuery = true)
	int insertIntoRoleUsers(@Param("roleId") Long roleId, @Param("userId") Long userId);
	
	@Modifying
	@Query(value = "DELETE FROM public.role_users WHERE user_role_role_id=?1 ;", nativeQuery = true)
	int deleteFromRoleUsersByRole(Long roleId);
	
	@Modifying
	@Query(value = "DELETE FROM public.role_users WHERE users_user_id=?1 ;", nativeQuery = true)
	int deleteFromRoleUsersByUsers(Long roleId);

	@Query(value = "SELECT user_role_role_id, users_user_id FROM public.role_users WHERE role_role_id=?1 ;", nativeQuery = true)
	int getUsersFromRoleId(Long roleId);
	
	@Modifying
	@Query(value = "UPDATE public.role_users SET user_role_role_id=?2, users_user_id=?3 WHERE role_role_id=?1 ;", nativeQuery = true)
	int updateRoleUsersByRoleId(Long oldRoleId, Long newRoleId, Long userId);
	
	@Modifying
	@Query(value = "UPDATE public.role_users SET user_role_role_id=?3, users_user_id=?2 WHERE user_role_role_id=?1 ;", nativeQuery = true)
	int updateRoleUsersByUserId(Long oldUserId, Long newUserId, Long roleId);
}
