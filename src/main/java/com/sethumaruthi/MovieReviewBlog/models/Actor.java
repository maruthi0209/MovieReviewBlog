package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@Column(name = "actor_id", nullable = false)
	private Long actorId;
	
	@Column(name = "actor_name", nullable = false)
	private String actorName;

	public Actor() {
	}

	public Actor(Long actorId, String actorName) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + "]";
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
	
	

}
