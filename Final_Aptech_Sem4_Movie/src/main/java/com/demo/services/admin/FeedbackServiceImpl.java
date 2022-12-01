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
import com.demo.models.Movie;
import com.demo.repositories.admin.MovieRepository;
import com.demo.repositories.admin.AccountRepository;
import com.demo.repositories.admin.FeedbackRepository;





@Service("AdminFeedbackImplservice")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	

	@Override
	public Page<Feedback> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 20);
		return feedbackRepository.findAll(pageable);
	}
	
	@Override
	public List<Feedback> findAllByMovieId(String keyword) {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		List<Movie> ms = movieRepository.findByKeyWord(keyword);
		for(Movie m :ms) {
			List<Feedback> f = feedbackRepository.findAllFeedbackByMoiveid(m.getId());
			for(Feedback i : f) {
				feedbacks.add(i);
			}
		}
		return feedbacks;
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
