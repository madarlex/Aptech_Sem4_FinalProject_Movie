package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.Feedback;



@Service("AdminFeedbackService")
public interface FeedbackService {


	
	public Page<Feedback> findAll(int numberPage);
	public Page<Feedback> findAllByMovieId(int numberPage,int movieid);
	public void delete(Feedback f);
	public Feedback findById(int id);
}
