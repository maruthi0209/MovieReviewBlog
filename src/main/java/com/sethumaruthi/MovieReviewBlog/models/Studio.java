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
	private String studio_name;

	public Studio() {
	}

	public Studio(Long studioId, String studio_name) {
		super();
		this.studioId = studioId;
		this.studio_name = studio_name;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studio_name=" + studio_name + "]";
	}

	public Long getStudioId() {
		return studioId;
	}

	public void setStudioId(Long studioId) {
		this.studioId = studioId;
	}

	public String getStudio_name() {
		return studio_name;
	}

	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	
	

}
