package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@Column(name = "review_id", nullable = false)
	private Long reviewId;
	
	@Column(name = "review_title", nullable = false)
	private String reviewTitle;
	
	@Column(name = "review_description", nullable = false)
	private String reviewDescription;
	
	@Column(name = "review_rating", nullable = false)
	private int reviewRating;
	
	private ReviewUser user;

	public Review() {
		super();
	}

	public Review(Long reviewId, String reviewTitle, String reviewDescription, int reviewRating, ReviewUser user) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.reviewDescription = reviewDescription;
		this.reviewRating = reviewRating;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewDescription="
				+ reviewDescription + ", reviewRating=" + reviewRating + ", user=" + user + "]";
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

	public ReviewUser getUser() {
		return user;
	}

	public void setUser(ReviewUser user) {
		this.user = user;
	}
		
}
