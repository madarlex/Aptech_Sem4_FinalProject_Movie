package com.demo.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.MovieService;



@Controller
@RequestMapping({ "", "home" })
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap modelMap, Principal principal, HttpSession session) {


		
		modelMap.put("movies", movieService.findAll());
		modelMap.put("hotMovies", movieService.findAllHotMovie());
		modelMap.put("commingSoonMovies", movieService.findAllComingSoonMovie());
		modelMap.put("movieOrderByRate", movieService.findAllorderByRateLimitMovie());
		return "home/index";
	}
	
}
