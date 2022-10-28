package com.demo.controllers;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.services.AccountService;
import com.demo.services.MovieService;
import com.demo.services.MovieshowtimeService;



@Controller
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieshowtimeService movieshowtimeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(ModelMap modelMap, 
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy, HttpServletRequest request) {
		float totalRecord = movieService.countMovieRecord();
		int totalPage =  (int) Math.ceil(totalRecord/10);
		String uri = request.getScheme() + "://" +
	             request.getServerName() + 
	             ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort() ) +
	             request.getRequestURI() +
	            (request.getQueryString() != null ? "?" + request.getQueryString() : "");
		modelMap.put("movies", movieService.findAllPagination(pageNo, pageSize, sortBy));
		modelMap.put("totalPage", totalPage);
		modelMap.put("totalRecord", (int) totalRecord);
		modelMap.put("uri", uri);
		return "movie/list";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword ) {
		modelMap.put("movies", movieService.findMovieByKeyword(keyword));
		return "movie/search";
	}
	
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(ModelMap modelMap,@PathVariable("id") int id) {
		modelMap.put("movie", movieService.findById(id));
		modelMap.put("showtimemovies",  movieService.findById(id).getMovieshowtimes());
		return "movie/detail";
	}
	
}
