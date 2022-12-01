package com.demo.models;

public class PriceByMovie {
	private Movie movie;
	private double total;
	
	public PriceByMovie() {
		// TODO Auto-generated constructor stub
	}
	
	public PriceByMovie(Movie movie, double total) {
		super();
		this.movie = movie;
		this.total = total;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
