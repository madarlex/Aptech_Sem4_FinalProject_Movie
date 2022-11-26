package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.demo.models.Movie;




public interface MovieService {
	public Iterable<Movie> findAll();
	public List<Movie> findAllNowShowingMovie();
	public List<Movie> findAllActiveMovie();
	public List<Movie> findAllHotMovie();
	public List<Movie> findAllComingSoonMovie();
	public List<Movie> findAllorderByRateLimitMovie();
	public List<Movie> findAllPagination(Integer pageNo, Integer pageSize, String sortBy);
	public Movie findById(int id);
	public int countMovieRecord();
	public List<Movie> findMovieByKeyword(String keyword);
}
