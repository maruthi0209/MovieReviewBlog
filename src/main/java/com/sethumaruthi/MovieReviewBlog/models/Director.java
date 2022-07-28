package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "director")
public class Director {
	
	@Id
	@Column(name = "director_id", nullable = false)
	private Long directorId;
	
	@Column(name = "director_name", nullable = false)
	private String directorName;
	
	@ManyToMany
	private List<Movie> directorMovies;

	public Director() {
		
	}

	public Director(Long directorId, String directorName, List<Movie> directorMovies) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.directorMovies = directorMovies;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", directorMovies="
				+ directorMovies + "]";
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

	public List<Movie> getDirectorMovies() {
		return directorMovies;
	}

	public void setDirectorMovies(List<Movie> directorMovies) {
		this.directorMovies = directorMovies;
	}

}
