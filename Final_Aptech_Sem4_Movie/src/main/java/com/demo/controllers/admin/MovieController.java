package com.demo.controllers.admin;

import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.models.Movie;
import com.demo.services.admin.MovieService;

@Controller("AdminMovieController")
@RequestMapping({"admin/movie"})
public class MovieController implements ServletContextAware {
	@Autowired
	private MovieService movieService;
	private ServletContext _servletContext;
	private int currPage;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.put("movie", new Movie());
		modelMap.put("p", "../movie/index.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "movies", method = RequestMethod.GET)
	public String movies (ModelMap modelMap,HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1,session);
	}
	@GetMapping("/movies/{pageNumber}")
	public String listByPage (ModelMap modelMap,@PathVariable("pageNumber") int currentPage,HttpSession session) {
		Page<Movie> page = movieService.findAll(currentPage);
		List<Movie> movies = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("movies", movies);
		modelMap.put("p", "../movie/movies.jsp");
		return "admin/layouts/index";
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add (ModelMap modelMap, @ModelAttribute("movie") Movie movie, @RequestParam("file") MultipartFile file) {
		String[] names = movie.getName().split(" ");
		String shortname= "";
		for(var n : names) {
			shortname += n.charAt(0);
		}
		try {
			movie.setStartDate(movie.getStartDate());
			movie.setEndDate(movie.getEndDate());
			movie.setComingSoon(movie.getStartDate().after(new Date()));
			movie.setNowShowing(movie.getStartDate().before(new Date()) && movie.getEndDate().after(new Date()));
		}catch(Exception e) {
			e.printStackTrace();
			movie.setStartDate(new Date());
			movie.setEndDate(new Date());
		}
		movie.setHotMovie(movie.getRate() >= 4);
		
		
		movie.setStatus(true);
		movie.setPicture(UploadFile(file));
		movie.setShortName(shortname);
		if(movieService.create(movie)) {
			System.out.print("Done");
		}else {
			System.out.print("Failed");
		}
//		modelMap.put("p", "../movie/index.jsp");
//		return "layouts/index";
		return "redirect:/admin/movie/movies";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit (ModelMap modelMap,@PathVariable("id")int id) {
		modelMap.put("movie", movieService.findById(id));
		modelMap.put("p", "../movie/edit.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit (ModelMap modelMap,@ModelAttribute("movie") Movie movie, @RequestParam("file") MultipartFile file) {
		Movie m = movieService.findById(movie.getId());
		String[] names = movie.getName().split(" ");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String shortname= "";
		for(var n : names) {
			shortname += n.charAt(0);
		}
		if(file.getSize() > 0) {
			movie.setPicture(UploadFile(file));
		}else {
			movie.setPicture(m.getPicture());
		}
		try {
//			Date startdate = format.parse(startDate);
//			Date enddate = format.parse(endDate);
			movie.setStartDate(movie.getStartDate());
			movie.setEndDate(movie.getEndDate());
			movie.setComingSoon(movie.getStartDate().after(new Date()));
			movie.setNowShowing(movie.getStartDate().before(new Date()) && movie.getEndDate().after(new Date()));
		}catch(Exception e) {
			e.printStackTrace();
			movie.setStartDate(new Date());
			movie.setEndDate(new Date());
		}
		movie.setShortName(shortname);
		movie.setHotMovie(movie.getRate() >= 4);
		movie.setStatus(true);
		if(movieService.create(movie)) {
			System.out.print("Done");
		}else {
			System.out.print("Failed");
		}
		modelMap.put("p", "../movie/index.jsp");
		return "redirect:/admin/movie/movies";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete (ModelMap modelMap,@PathVariable("id")int id) {
		Movie m = movieService.findById(id);
		movieService.delete(m);
		modelMap.put("movie", new Movie());
		return "redirect:/admin/movie/movies";
	}
	
	
	private String generateFileName(String filename) {
		String name= UUID.randomUUID().toString().replace("-","");
		int lastIndex= filename.lastIndexOf(".");
		return name+filename.substring(lastIndex);
	}
	
	private String UploadFile(MultipartFile file) {
		try {
			String filename= generateFileName(file.getOriginalFilename());
			byte[] bytes= file.getBytes();
			Path path = Paths.get(this._servletContext.getRealPath("/assets/uploads/images/" + filename));
			Files.write(path, bytes);
			return filename;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public void setServletContext(ServletContext servletContext) {
		this._servletContext = servletContext;
		
	}
	
	
	
}
