package com.demo.controllers;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.models.Account;
import com.demo.models.AddedFeedback;
import com.demo.models.Feedback;
import com.demo.models.Movie;
import com.demo.models.Price;
import com.demo.services.AccountService;
import com.demo.services.FeedbackService;
import com.demo.services.MovieService;
import com.demo.services.MovieshowtimeService;


@SessionAttributes({"feedback"})
@Controller
@RequestMapping("feedback")
public class FeedbackController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String detail(@ModelAttribute("feedback") AddedFeedback addedFeedback, HttpSession session, Authentication authentication) {
		Account account = accountService.findByUsername(authentication.getName());
		Feedback feedback = new Feedback();
		Movie movie = movieService.findById(Integer.parseInt(addedFeedback.getMovieId()));
		feedback.setAccount(account);
		feedback.setMovie(movie);
		feedback.setContent(addedFeedback.getContent());
		feedback.setCommentDate(new Date());
		feedback.setStatus(true);
		feedback.setRating(Integer.parseInt(addedFeedback.getStarRating()));
		feedbackService.save(feedback);
		return "redirect:/movie/detail/" + addedFeedback.getMovieId();
	}
	
}
