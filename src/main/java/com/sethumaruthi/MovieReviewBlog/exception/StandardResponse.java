package com.sethumaruthi.MovieReviewBlog.exception;

public class StandardResponse {
	
	String responseMessage;

	public StandardResponse() {
		super();
	}

	public StandardResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "StandardResponse [responseMessage=" + responseMessage + "]";
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

		
}
