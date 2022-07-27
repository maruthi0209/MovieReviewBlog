package com.sethumaruthi.MovieReviewBlog.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String releaseDate;
	
	@Column(name = "budget", nullable = false)
	private Long budget;
	
	@Column(name = "box_office", nullable = false)
	private Long boxOffice;
	
	@ManyToMany
	private List<Genre> movieGenre;
	
	@ManyToMany
	private List<Actor> movieCast;
	
	private Director movieDirector;
	
	private Studio movieStudio;
	
	@OneToMany
	private List<Review> movieReviews;

	public Movie() {
		super();
	}

	public Movie(Long movieId, String movieName, String releaseDate, Long budget, Long boxOffice,
			List<Genre> movieGenre, List<Actor> movieCast, Director movieDirector, Studio movieStudio,
			List<Review> movieReviews) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.boxOffice = boxOffice;
		this.movieGenre = movieGenre;
		this.movieCast = movieCast;
		this.movieDirector = movieDirector;
		this.movieStudio = movieStudio;
		this.movieReviews = movieReviews;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", budget="
				+ budget + ", boxOffice=" + boxOffice + ", movieGenre=" + movieGenre + ", movieCast=" + movieCast
				+ ", movieDirector=" + movieDirector + ", movieStudio=" + movieStudio + ", movieReviews=" + movieReviews
				+ "]";
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
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

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public Long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(Long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public List<Review> getMovieReviews() {
		return movieReviews;
	}

	public void setMovieReviews(List<Review> movieReviews) {
		this.movieReviews = movieReviews;
	}
	
	
	
}