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

import com.demo.models.Feedback;
import com.demo.repositories.FeedBackRepository;




@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Override
	public Iterable<Feedback> findAllByMovie(int movie_id) {
		// TODO Auto-generated method stub
		return feedBackRepository.findAllFeedbackByMovie(movie_id);
	}

	@Override
	public Feedback save(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedBackRepository.save(feedback);
	}



}
