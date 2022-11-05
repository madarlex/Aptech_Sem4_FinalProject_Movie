package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Feedback;


public interface FeedbackService {
	public Iterable<Feedback> findAllByMovie(int movie_id);
	public Feedback save(Feedback feedback);
}
