package com.sethumaruthi.MovieReviewBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sethumaruthi.MovieReviewBlog.models.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long>{

	@Modifying
	@Query(value = "DELETE FROM public.movie_movie_cast WHERE movie_cast_actor_id = ?1 ;", nativeQuery = true)
	int deleteMovieCast(Long actorId);
	
	@Modifying
	@Query(value = "INSERT INTO public.actor_actor_movies(actor_actor_id, actor_movies_movie_id) VALUES (:actorId, :movieId);", nativeQuery = true)
	int insertIntoActorMovies(@Param("actorId") Long actorId, @Param("movieId") Long movieId);
	
	@Modifying
	@Query(value = "DELETE FROM public.actor_actor_movies WHERE actor_movies_movie_id=?1 ;", nativeQuery = true)
	int deleteActorMoviesByMovieId(Long movieId);
	
	@Modifying
	@Query(value = "DELETE FROM public.actor_actor_movies WHERE actor_actor_id=?1 ;", nativeQuery = true)
	int deleteActorMoviesByActorId(Long actorId);
	
	@Query(value = "SELECT actor_actor_id, actor_movies_movie_id FROM public.actor_actor_movies WHERE actor_actor_id=?1 ;", nativeQuery = true)
	List<Long> getMovieListByActor(Long actorId);
	
	@Modifying
	@Query(value = "UPDATE public.actor_actor_movies SET actor_actor_id=?2 , actor_movies_movie_id=?3 WHERE actor_actor_id=?1;", nativeQuery = true)
	int updateActorMoviesByActorId(Long oldActorId, Long newActorId, Long movieId);
	
	@Modifying
	@Query(value = "UPDATE public.actor_actor_movies SET actor_actor_id=?3 , actor_movies_movie_id=?2 WHERE actor_movies_movie_id=?1;", nativeQuery = true)
	int updateActorMoviesByMovieId(Long oldMovieId, Long newMovieId, Long ActorId);

}
