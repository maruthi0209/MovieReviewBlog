package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@Column(name = "review_id", nullable = false)
	private Long reviewId;
	
	@Length(min = 1, max = 50, message = "Review title should be between 1-50 chars")
	@Column(name = "review_title", nullable = false)
	private String reviewTitle;
	
	@Column(name = "review_description", nullable = false)
	private String reviewDescription;
	
	@Column(name = "review_rating", nullable = false)
	private int reviewRating;
	
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Movie movie;

	public Review() {
		super();
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewDescription="
				+ reviewDescription + ", reviewRating=" + reviewRating + ", user=" + user + ", movie=" + movie + "]";
	}

	public Review(Long reviewId, String reviewTitle, String reviewDescription, int reviewRating, AppUser user,
			Movie movie) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.reviewDescription = reviewDescription;
		this.reviewRating = reviewRating;
		this.user = user;
		this.movie = movie;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
		
}
