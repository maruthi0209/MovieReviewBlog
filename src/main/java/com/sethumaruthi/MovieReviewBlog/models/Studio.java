package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studio")
public class Studio {
	
	@Id
	@Column(name = "studio_id", nullable = false)
	private Long studioId;
	
	@Column(name = "studio_name", nullable = false)
	private String studioName;
	
	@OneToMany
	private List<Movie> studioMovies;

	public Studio() {
	}

	public Studio(Long studioId, String studioName, List<Movie> studioMovies) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.studioMovies = studioMovies;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studioName=" + studioName + ", studioMovies=" + studioMovies + "]";
	}

	public Long getStudioId() {
		return studioId;
	}

	public void setStudioId(Long studioId) {
		this.studioId = studioId;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public List<Movie> getStudioMovies() {
		return studioMovies;
	}

	public void setStudioMovies(List<Movie> studioMovies) {
		this.studioMovies = studioMovies;
	}


}
