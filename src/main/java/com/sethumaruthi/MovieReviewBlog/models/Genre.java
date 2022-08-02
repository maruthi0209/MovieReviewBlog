package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@Column(name = "genre_description", nullable = false)
	private String genreDescription;
	
//	@ManyToMany
//	private List<Movie> genreMovies;

	public Genre() {
		super();
	}

	public Genre(Long genreId, String genreDescription, List<Movie> genreMovies) {
		super();
		this.genreId = genreId;
		this.genreDescription = genreDescription;
//		this.genreMovies = genreMovies;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreDescription=" + genreDescription + ", genreMovies="				+ "]";
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

//	public List<Movie> getGenreMovies() {
//		return genreMovies;
//	}
//
//	public void setGenreMovies(List<Movie> genreMovies) {
//		this.genreMovies = genreMovies;
//	}
	
}
