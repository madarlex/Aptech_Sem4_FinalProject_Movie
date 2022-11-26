package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Movie;
import com.demo.repositories.MovieRepository;





@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Iterable<Movie> findAll() {
		return movieRepository.findAll(); 
	}

	@Override
	public List<Movie> findAllActiveMovie() {
		return movieRepository.findAllActiveMovie();
	}

	@Override
	public List<Movie> findAllHotMovie() {
		return movieRepository.findAllHotMovie();
	}

	@Override
	public List<Movie> findAllComingSoonMovie() {
		return movieRepository.findAllComingSoonMovie();
	}

	@Override
	public List<Movie> findAllorderByRateLimitMovie() {
		return movieRepository.findAllorderByRateLimitMovie();
	}

	@Override
	public List<Movie> findAllPagination(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
        Page<Movie> pagedResult = movieRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Movie>();
        }
	}

	@Override
	public int countMovieRecord() {
		return movieRepository.countMovieRecord();
	}

	@Override
	public Movie findById(int id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public List<Movie> findMovieByKeyword(String keyword) {
		return movieRepository.findMovieByKeyword(keyword);
	}

	@Override
	public List<Movie> findAllNowShowingMovie() {
		// TODO Auto-generated method stub
		return movieRepository.findAllNowShowingMovie();
	}


}
