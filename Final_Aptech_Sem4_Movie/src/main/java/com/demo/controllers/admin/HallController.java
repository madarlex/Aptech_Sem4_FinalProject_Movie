package com.demo.controllers.admin;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Hall;
import com.demo.services.admin.HallService;

@Controller("AdminHallController")
@RequestMapping({"admin/hall"})
public class HallController {
	
	String LIST_HALL = "";
	private int currPage;
	
	@Autowired
	private HallService hallService;
	
	@RequestMapping(value = {"add"}, method = RequestMethod.GET)
	public String add (ModelMap modelMap) {
		modelMap.put("hall", new Hall());
		modelMap.put("p", "../hall/add.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.POST)
	public String add (@ModelAttribute("hall") Hall hall) {
		try {
			hall.setStatus(true);
			if (hallService.create(hall)) {
				return "redirect:/admin/hall/halls";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"edit/{id}"}, method = RequestMethod.GET)
	public String edit (ModelMap modelMap, @PathVariable("id")int id) {
		modelMap.put("hall", hallService.findById(id));
		modelMap.put("p", "../hall/edit.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.POST)
	public String edit (@ModelAttribute("hall") Hall hall) {
		Hall dbHall = hallService.findById(hall.getId());
		dbHall.setName(hall.getName());
		dbHall.setSeatNumbers(hall.getSeatNumbers());
		try {
			hall.setStatus(true);
			if (hallService.create(dbHall)) {
				return "redirect:/admin/hall/halls";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "halls", method = RequestMethod.GET)
	public String movies (ModelMap modelMap,HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1,session);
	}
	@GetMapping("/halls/{pageNumber}")
	public String listByPage (ModelMap modelMap,@PathVariable("pageNumber") int currentPage,HttpSession session) {
		Page<Hall> page = hallService.findAll(currentPage);
		List<Hall> halls = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("halls", halls);
		modelMap.put("p", "../hall/halls.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete (ModelMap modelMap,@PathVariable("id")int id) {
		Hall hall = hallService.findById(id);
		hallService.delete(hall);
		//modelMap.put("movie", new Movie());
		return "redirect:/admin/hall/halls";
	}
}
