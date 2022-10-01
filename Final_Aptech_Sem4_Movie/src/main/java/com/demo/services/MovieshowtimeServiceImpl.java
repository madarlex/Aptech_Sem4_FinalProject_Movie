package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.models.Movie;
import com.demo.models.Movieshowtime;
import com.demo.repositories.MovieRepository;
import com.demo.repositories.MovieshowtimeRepository;





@Service
public class MovieshowtimeServiceImpl implements MovieshowtimeService {

	@Autowired
	private MovieshowtimeRepository movieshowtimeRepository;
	
	@Override
	public Iterable<Movieshowtime> findAll() {
		return movieshowtimeRepository.findAll();
	}

	@Override
	public List<Movie> findShowtimemovieByMovieId(int movieId) {
		return movieshowtimeRepository.findShowtimemovieByMovieId(movieId);
	}

	@Override
	public Movieshowtime findById(int id) {
		// TODO Auto-generated method stub
		return movieshowtimeRepository.findById(id).get();
	}

}
