package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.models.Movie;
import com.demo.models.Movieshowtime;
import com.demo.repositories.admin.MovieRepository;
import com.demo.repositories.admin.MovieshowtimeRepository;





@Service("AdminMovieshowtimeService")
public class MovieshowtimeServiceImpl implements MovieshowtimeService {

	@Autowired
	private MovieshowtimeRepository movieshowtimeRepository;
	
	@Override
	public Iterable<Movieshowtime> findAll() {
		return movieshowtimeRepository.findAll();
	}

	@Override
	public List<Movieshowtime> findShowtimemovieByMovieId(int movieId) {
		return movieshowtimeRepository.findShowtimemovieByMovieId(movieId);
	}


	@Override
	public Page<Movieshowtime> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 20);
		return movieshowtimeRepository.findAllByStatus(pageable);
	}

	@Override
	public boolean create(Movieshowtime movieshowtime) {
		if (movieshowtimeRepository.save(movieshowtime) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Movieshowtime> findShowtimemovieByMovieIdAndByDate(int movieId, Date date) {
		return movieshowtimeRepository.findShowtimemovieByMovieIdAndByDate(movieId, date);
	}

	@Override
	public Movieshowtime findById(int id) {
		return movieshowtimeRepository.findById(id);
	}

	@Override
	public void delete(Movieshowtime showtime) {
		movieshowtimeRepository.delete(showtime);
	}
	
//	@Override
//	public List<Movieshowtime> findShowtimeByDate(Date date) {
//		return movieshowtimeRepository.findShowTimeByDate(date);
//	}

}
