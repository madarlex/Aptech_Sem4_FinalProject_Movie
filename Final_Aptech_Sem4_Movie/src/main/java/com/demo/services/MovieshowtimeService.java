package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Movie;
import com.demo.models.Movieshowtime;




public interface MovieshowtimeService {
	public Iterable<Movieshowtime> findAll();
	public List<Movie> findShowtimemovieByMovieId(int movieId);
	public Movieshowtime findById(int id);
}
