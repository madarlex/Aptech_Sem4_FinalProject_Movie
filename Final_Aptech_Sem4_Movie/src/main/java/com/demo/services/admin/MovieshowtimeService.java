package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.models.Movie;
import com.demo.models.Movieshowtime;



@Service
public interface MovieshowtimeService {

	public Iterable<Movieshowtime> findAll();
	
	public List<Movieshowtime> findShowtimemovieByMovieId(int movieId);
	
	public Movieshowtime findById(int id);
	
	public Page<Movieshowtime> findAll(int numberPage);
	
	public boolean create (Movieshowtime movieshowtime);
	
	public List<Movieshowtime> findShowtimemovieByMovieIdAndByDate(int movieId, Date date);
	
	public void delete(Movieshowtime showtime);
//	
//	public List<Movieshowtime> findShowtimeByDate(Date date);
}
