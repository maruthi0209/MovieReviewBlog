package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@Column(name = "genre_description", nullable = false)
	private String genreDescription;

	public Genre() {
		super();
	}

	public Genre(Long genreId, String genreDescription) {
		super();
		this.genreId = genreId;
		this.genreDescription = genreDescription;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreDescription=" + genreDescription + "]";
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreDescription() {
		return genreDescription;
	}

	public void setGenreDescription(String genreDescription) {
		this.genreDescription = genreDescription;
	}
	
	
}
