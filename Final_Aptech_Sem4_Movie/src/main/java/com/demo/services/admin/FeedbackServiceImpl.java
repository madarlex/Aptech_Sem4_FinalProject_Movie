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

import com.demo.models.Account;
import com.demo.models.Feedback;
import com.demo.repositories.admin.AccountRepository;
import com.demo.repositories.admin.FeedbackRepository;





@Service("AdminFeedbackImplservice")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	

	@Override
	public Page<Feedback> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 5);
		return feedbackRepository.findAll(pageable);
	}


	@Override
	public Page<Feedback> findAllByMovieId(int numberPage, int movieid) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 5);
		return feedbackRepository.findAllFeedbackByMoiveid(movieid,pageable);
	}


	@Override
	public void delete(Feedback f) {
		feedbackRepository.delete(f);
	}


	@Override
	public Feedback findById(int id) {
		return feedbackRepository.findFeedbackById(id);
	}





}
