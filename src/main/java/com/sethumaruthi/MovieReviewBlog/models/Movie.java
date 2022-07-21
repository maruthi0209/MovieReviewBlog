package com.sethumaruthi.MovieReviewBlog.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@Column(name = "movie_id", nullable = false)
	private Long movieId;
	
	@Column(name = "movie_name", nullable = false) 
	private String movieName;
	
	@Column(name = "release_date", nullable = false)
	private LocalDate releaseDate;
	
	@ManyToMany
	private List<Genre> movieGenre;
	
	@ManyToMany
	private List<Actor> movieCast;
	
	@ManyToOne
	private Director movieDirector;
	
	@ManyToOne
	private Studio movieStudio;

	public Movie() {
		super();
	}

	public Movie(Long movieId, String movieName, LocalDate releaseDate, List<Genre> movieGenre, List<Actor> movieCast,
			Director movieDirector, Studio movieStudio) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.movieGenre = movieGenre;
		this.movieCast = movieCast;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate
				+ ", movieGenre=" + movieGenre + ", movieCast=" + movieCast + ", movieDirector=" + movieDirector
				+ ", movieStudio=" + movieStudio + "]";
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Genre> getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(List<Genre> movieGenre) {
		this.movieGenre = movieGenre;
	}

	public List<Actor> getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(List<Actor> movieCast) {
		this.movieCast = movieCast;
	}

	public Director getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(Director movieDirector) {
		this.movieDirector = movieDirector;
	}

	public Studio getMovieStudio() {
		return movieStudio;
	}

	public void setMovieStudio(Studio movieStudio) {
		this.movieStudio = movieStudio;
	}

	
	

}