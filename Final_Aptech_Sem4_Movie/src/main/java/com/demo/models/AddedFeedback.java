package com.demo.models;

import java.util.Date;

public class AddedFeedback {
	private String content;
	private String movieId;
	private String starRating;
	

	public String getStarRating() {
		return starRating;
	}
	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public AddedFeedback(String content, String movieId, String starRating) {
		super();
		this.content = content;
		this.movieId = movieId;
		this.starRating = starRating;
	}
	public AddedFeedback() {
		super();
	}

}
