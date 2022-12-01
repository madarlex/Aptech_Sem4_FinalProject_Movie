package com.demo.controllers.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.admin.AccountService;
import com.demo.services.admin.CanvasjsChartService;
import com.demo.services.admin.MovieService;
import com.demo.services.admin.MovieshowtimeService;
import com.demo.services.admin.TicketService;

@Controller("AdminHomeController")
@RequestMapping({"admin/home", "admin"})
public class HomeControllers {
	
	@Autowired
	private CanvasjsChartService canvasjsChartService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieshowtimeService movieshowtimeService;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		List<List<Map<Object, Object>>> columnDataList = canvasjsChartService.getColumnChartData();
		List<List<Map<Object, Object>>> lineDataList = canvasjsChartService.getLineChartData();
		modelMap.put("p", "../home/index.jsp");
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("columnDataPointsList", columnDataList);
		modelMap.addAttribute("lineDataPointsList", lineDataList);
		modelMap.addAttribute("movieList", movieService.findMovieByNowShowing());
		modelMap.addAttribute("totalRevenue", ticketService.getTotalRevenue());
		modelMap.addAttribute("showtimes", movieshowtimeService.findAll());
		modelMap.put("movies", movieService.findMovieByNowShowing());
		modelMap.put("movieSchedules", movieshowtimeService.getScheduleOfMovieNowShowing());
		modelMap.addAttribute("countAccount", accountService.countAccount());
		modelMap.addAttribute("countMovie", movieService.countMovieNowShowing());
		modelMap.addAttribute("countTicket", ticketService.countTicket(new Date()));
		return "admin/layouts/index";
	}
}
