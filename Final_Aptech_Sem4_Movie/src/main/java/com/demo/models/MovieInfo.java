package com.demo.models;

public class MovieInfo {
	private int movieId; 
	private int booking;
	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}
	public MovieInfo(int movieId, int booking) {
		super();
		this.movieId = movieId;
		this.booking = booking;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getBooking() {
		return booking;
	}
	public void setBooking(int booking) {
		this.booking = booking;
	}
	
	

	
}
