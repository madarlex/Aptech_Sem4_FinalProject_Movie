package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.models.Movie;
import com.demo.models.MovieSchedule;
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
	
	public int checkValidateHallAndShowTime(int hallId, String showDate, String showTime, String endTime);
	
	public List<String> getMovieNowShowingHasSchedule(); 
	
	public List<MovieSchedule> getScheduleOfMovieNowShowing();
	
	public List<Movieshowtime> findAllScheduleNowShowing();
	
	public List<Movieshowtime> findShowtimeByDate(String date);
	
	public List<Movieshowtime> findByKeyword(String keyword);
//	
//	public List<Movieshowtime> findShowtimeByDate(Date date);
}
