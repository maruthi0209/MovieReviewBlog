package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "director")
public class Director {
	
	@Id
	@Column(name = "director_id", nullable = false)
	private Long directorId;
	
	@Column(name = "director_name", nullable = false)
	private String directorName;

	public Director() {
		
	}

	public Director(Long directorId, String directorName) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + "]";
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	

}
