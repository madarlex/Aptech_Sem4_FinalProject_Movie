package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Movie;
import com.demo.repositories.admin.MovieRepository;

@Service("AdminMovieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public boolean create(Movie movie) {
		try {
			movieRepository.save(movie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Movie findById(int id) {
		return movieRepository.findMovieById(id);
	}

	@Override
	public void delete(Movie movie) {
		movieRepository.delete(movie);;
	}

	@Override
	public List<Movie> findMovieByTimeRange(Date start, Date end) {
		return movieRepository.findMovieByTime(start, end);
	}

	@Override
	public Iterable<Movie> showAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findMovieByTimeFromNow(Date today) {
		return movieRepository.findMovieByTimeFromToday(today);
	}

	@Override
	public Page<Movie> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 5);
		return movieRepository.findAll(pageable);
	}

}
