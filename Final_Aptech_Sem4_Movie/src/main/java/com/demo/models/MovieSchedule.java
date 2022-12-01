package com.demo.models;

import java.util.ArrayList;
import java.util.List;

public class MovieSchedule {
	private Movie movie;
	private List<ShowTimeAvailableSeats> movieshowtimes = new ArrayList<>();
	private int availableSeats;
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<ShowTimeAvailableSeats> getMovieshowtimes() {
		return movieshowtimes;
	}
	public void setMovieshowtimes(List<ShowTimeAvailableSeats> movieshowtimes) {
		this.movieshowtimes = movieshowtimes;
	}
	public MovieSchedule() {
		// TODO Auto-generated constructor stub
	}
}
