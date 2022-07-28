package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@Column(name = "actor_id", nullable = false)
	private Long actorId;
	
	@Column(name = "actor_name", nullable = false)
	private String actorName;
	
	@ManyToMany
	private List<Movie> actorMovies;

	public Actor() {
	}
	
	public Actor(Long actorId, String actorName, List<Movie> actorMovies) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorMovies = actorMovies;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorMovies=" + actorMovies + "]";
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public List<Movie> getActorMovies() {
		return actorMovies;
	}

	public void setActorMovies(List<Movie> actorMovies) {
		this.actorMovies = actorMovies;
	}

}
