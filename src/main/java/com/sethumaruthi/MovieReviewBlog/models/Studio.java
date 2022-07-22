package com.sethumaruthi.MovieReviewBlog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studio")
public class Studio {
	
	@Id
	@Column(name = "studio_id", nullable = false)
	private Long studioId;
	
	@Column(name = "studio_name", nullable = false)
	private String studioName;

	public Studio() {
	}

	public Studio(Long studioId, String studioName) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studioName=" + studioName + "]";
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

	

}
