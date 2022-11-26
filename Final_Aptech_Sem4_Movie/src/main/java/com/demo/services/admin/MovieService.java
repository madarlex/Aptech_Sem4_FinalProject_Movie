package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Movie;


public interface MovieService {

	public boolean create(Movie movie);
	
	public Movie findById(int id);
	
	public void delete(Movie movie);
	
	public List<Movie> findMovieByTimeRange(Date start, Date end);
	
	public List<Movie> findMovieByTimeFromNow(Date today);
	
	public Iterable<Movie> showAll();

	public Page<Movie> findAll(int numberPage);
	
	public List<Movie> findMovieByNowShowing();
}
