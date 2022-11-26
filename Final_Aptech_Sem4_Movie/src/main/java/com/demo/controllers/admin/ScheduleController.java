package com.demo.controllers.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.Hall;
import com.demo.models.Movie;
import com.demo.models.Movieshowtime;
import com.demo.services.admin.HallService;
import com.demo.services.admin.MovieService;
import com.demo.services.admin.MovieshowtimeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying;

@Controller("AdminScheduleController")
@RequestMapping({ "admin/schedule" })
public class ScheduleController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private HallService hallService;

	@Autowired
	private MovieshowtimeService movieshowtimeService;

	private int currPage;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("p", "../schedule/index.jsp");
		modelMap.put("movieList", movieService.findMovieByNowShowing());
		modelMap.put("hallList", hallService.findAll());
		return "admin/layouts/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id) {
		Movieshowtime showtime = movieshowtimeService.findById(id);
		modelMap.put("movieList", movieService.findMovieByNowShowing());
		modelMap.put("hallList", hallService.findAll());
		modelMap.put("showtime", showtime);
		System.out.println(showtime.getShowDate().toString() + "T" + showtime.getShowTime().toString());
		System.out.println(showtime.getShowTime().toString());
		String datetime = showtime.getShowDate().toString() + "T" + showtime.getShowTime().toString();
		modelMap.put("datetime", datetime);
		modelMap.put("p", "../schedule/edit.jsp");
		return "admin/layouts/index";
	}

	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String edit(ModelMap modelMap, @RequestParam("hall") int hallId, @RequestParam("movie") int movieId,
			@RequestParam("showTime") String showTime, @RequestParam("id") String id,
			RedirectAttributes redirectAttributes) {
		try {
			Movie movie = null;
			Hall hall = null;
			String showDateMsg = "";
			boolean foundError = false;
			String[] splitDateTime = showTime.split("T");
			System.out.println("showtime: " + showTime);
			Date date = parseDate(showTime, 0, "yyyy-MM-dd'T'HH:mm");
			Date endTime = new Date();
			String strDate = "";
			if (hallId != 0 && movieId != 0) {
				hall = hallService.findById(hallId);
				movie = movieService.findById(movieId);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int seconds = movie.getLength() * 60;
				calendar.add(Calendar.SECOND, seconds);
				endTime = calendar.getTime();
				DateFormat dateFormat = new SimpleDateFormat("HH:mm");  
				strDate = dateFormat.format(date);  
			}
			if (date.after(movie.getEndDate())) {
				foundError = true;
				showDateMsg = "You cannot set show date after the end date of movie";
				redirectAttributes.addFlashAttribute("showTimeMsg", showDateMsg);
				redirectAttributes.addFlashAttribute("hallId", hallId);
				redirectAttributes.addFlashAttribute("movieId", movieId);
				redirectAttributes.addFlashAttribute("datetime", showTime);
				System.out.println("false");
			}
			if (movieshowtimeService.checkValidateHallAndShowTime(hallId, splitDateTime[0], splitDateTime[1], strDate) > 0) {
				foundError = true;
				System.out.println("found: " + movieshowtimeService.checkValidateHallAndShowTime(hallId,
						splitDateTime[0], splitDateTime[1], strDate));
				showDateMsg = "This hall show the other movie at this time";
				redirectAttributes.addFlashAttribute("showTimeMsg", showDateMsg);
				redirectAttributes.addFlashAttribute("hallId", hallId);
				redirectAttributes.addFlashAttribute("movieId", movieId);
				redirectAttributes.addFlashAttribute("datetime", showTime);
				System.out.println("false");
			}
			if (foundError == false) {
				Movieshowtime movieshowtime = movieshowtimeService.findById(Integer.parseInt(id));
				movieshowtime.setHall(hall);
				movieshowtime.setMovie(movie);
				movieshowtime.setShowDate(date);
				movieshowtime.setShowTime(date);
				movieshowtime.setEndTime(endTime);
				if (movieshowtimeService.create(movieshowtime)) {
					return "redirect:/admin/schedule/schedules";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/schedule/eidt/" + id;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ModelMap modelMap, @RequestParam("hall") int hallId, @RequestParam("movie") int movieId,
			@RequestParam("showTime") String showTime, RedirectAttributes redirectAttributes) {
		try {
			Movie movie = null;
			Hall hall = null;
			String showDateMsg = "";
			boolean foundError = false;
			String[] splitDateTime = showTime.split("T");
//		Date date = parseDate(splitDateTime[0], 1, null);
//		Date time = parseDate(splitDateTime[1], 3, null);
			System.out.println("showtime: " + showTime);
			Date date = parseDate(showTime, 0, "yyyy-MM-dd'T'HH:mm");
			// Date date = new Date(showTime);
			Date endTime = new Date();
			String strDate = "";
			if (hallId != 0 && movieId != 0) {
				hall = hallService.findById(hallId);
				movie = movieService.findById(movieId);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int seconds = movie.getLength() * 60;
				calendar.add(Calendar.SECOND, seconds);
				endTime = calendar.getTime();
				DateFormat dateFormat = new SimpleDateFormat("HH:mm");  
				strDate = dateFormat.format(date);  
			}
			if (date.after(movie.getEndDate())) {
				foundError = true;
				showDateMsg = "You cannot set show date after the end date of movie";
				redirectAttributes.addFlashAttribute("showTimeMsg", showDateMsg);
				redirectAttributes.addFlashAttribute("hallId", hallId);
				redirectAttributes.addFlashAttribute("movieId", movieId);
				redirectAttributes.addFlashAttribute("datetime", showTime);
				System.out.println("false");
			}
			if (movieshowtimeService.checkValidateHallAndShowTime(hallId, splitDateTime[0], splitDateTime[1], strDate) > 0) {
				foundError = true;
				System.out.println("found: " + movieshowtimeService.checkValidateHallAndShowTime(hallId,
						splitDateTime[0], splitDateTime[1], strDate));
				showDateMsg = "This hall show the other movie at this time";
				redirectAttributes.addFlashAttribute("showTimeMsg", showDateMsg);
				redirectAttributes.addFlashAttribute("hallId", hallId);
				redirectAttributes.addFlashAttribute("movieId", movieId);
				redirectAttributes.addFlashAttribute("datetime", showTime);
				System.out.println("false");
			}
			if (foundError == false) {
				Movieshowtime movieshowtime = new Movieshowtime();
				movieshowtime.setHall(hall);
				movieshowtime.setMovie(movie);
				movieshowtime.setShowDate(date);
				movieshowtime.setShowTime(date);
				movieshowtime.setEndTime(endTime);
				movieshowtime.setStatus(true);
				if (movieshowtimeService.create(movieshowtime)) {
					return "redirect:/admin/schedule/schedules";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/schedule/index";
	}

	@RequestMapping(value = "schedules", method = RequestMethod.GET)
	public String schedules(ModelMap modelMap, HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1, session);
	}

	@GetMapping("/schedules/{pageNumber}")
	public String listByPage(ModelMap modelMap, @PathVariable("pageNumber") int currentPage, HttpSession session) {
		Page<Movieshowtime> page = movieshowtimeService.findAll(currentPage);
		List<Movieshowtime> schedules = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("schedules", schedules);
		modelMap.put("p", "../schedule/schedules.jsp");
		return "admin/layouts/index";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap modelMap, @PathVariable("id") int id) {

		Movieshowtime showtime = movieshowtimeService.findById(id);
		showtime.setStatus(false);
		if (movieshowtimeService.create(showtime)) {
			return "redirect:/admin/schedule/schedules";
		}
		// modelMap.put("movie", new Movie());
		return "redirect:/admin/schedule/schedules";
	}

	public static Date parseDate(String date, int type, String pattern) {
		try {
			if (pattern == null) {
				if (type == 1) {
					return new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} else if (type == 2) {
					return new SimpleDateFormat("HH:mm").parse(date);
				} else if (type == 3) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
				}
			} else {
				return new SimpleDateFormat(pattern).parse(date);
			}
		} catch (ParseException e) {
			return null;
		}
		return null;
	}
}
