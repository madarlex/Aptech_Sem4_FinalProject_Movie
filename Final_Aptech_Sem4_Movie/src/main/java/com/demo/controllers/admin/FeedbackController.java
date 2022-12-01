package com.demo.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.Feedback;
import com.demo.services.admin.FeedbackService;

@Controller("AdminFeedbackController")
@RequestMapping({"admin/feedback"})
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	private int currPage;
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index (ModelMap modelMap,HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1,session);
	}
	

	
	@GetMapping("/feedbacks/{pageNumber}")
	public String listByPage (ModelMap modelMap,@PathVariable("pageNumber") int currentPage,HttpSession session) {
		Page<Feedback> page = feedbackService.findAll(currentPage);
		List<Feedback> feedbacks = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("feedbacks", feedbacks);
		modelMap.put("p", "../feedback/index.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search (ModelMap modelMap,@RequestParam("keyword")String keyword,HttpSession session) {
		List<Feedback> feedbacks = feedbackService.findAllByMovieId(keyword);
		int totalPage = 1;
		currPage = 1;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == 1 ? "disabled" : " ");
		session.setAttribute("totalpage", 1);
		session.setAttribute("currentPage", 1);
		modelMap.put("currentPage", 1);
		modelMap.put("feedbacks", feedbacks);
		modelMap.put("p", "../feedback/index.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete (ModelMap modelMap,@PathVariable("id")int id) {
		Feedback f = feedbackService.findById(id);
		feedbackService.delete(f);
		return "redirect:/admin/feedback/index";
	}

}
