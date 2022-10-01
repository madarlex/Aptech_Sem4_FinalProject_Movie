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
import com.demo.models.Price;
import com.demo.services.admin.HallService;
import com.demo.services.admin.PriceService;

@Controller("AdminPriceController")
@RequestMapping({"admin/price"})
public class PriceController {
	
	String LIST_HALL = "";
	private int currPage;
	
	@Autowired
	private PriceService priceService;
	
	@RequestMapping(value = {"add"}, method = RequestMethod.GET)
	public String add (ModelMap modelMap) {
		modelMap.put("price", new Price());
		modelMap.put("p", "../price/add.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"edit/{id}"}, method = RequestMethod.GET)
	public String edit (ModelMap modelMap, @PathVariable("id")int id) {
		modelMap.put("price", priceService.findById(id));
		modelMap.put("p", "../price/edit.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.POST)
	public String add (@ModelAttribute("price") Price price) {
		try {
			price.setStatus(true);
			if (priceService.create(price)) {
				return "redirect:/admin/price/prices";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.POST)
	public String edit (@ModelAttribute("price") Price price) {
		Price dbPrice = priceService.findById(price.getId());
		dbPrice.setPrice(price.getPrice());
		dbPrice.setDescription(price.getDescription());
		try {
			dbPrice.setStatus(true);
			if (priceService.create(dbPrice)) {
				return "redirect:/admin/price/prices";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "prices", method = RequestMethod.GET)
	public String movies (ModelMap modelMap,HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1,session);
	}
	@GetMapping("/prices/{pageNumber}")
	public String listByPage (ModelMap modelMap,@PathVariable("pageNumber") int currentPage,HttpSession session) {
		Page<Price> page = priceService.findAll(currentPage);
		List<Price> prices = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("prices", prices);
		modelMap.put("p", "../price/prices.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete (ModelMap modelMap,@PathVariable("id")int id) {
		priceService.delete(id);
		//modelMap.put("movie", new Movie());
		return "redirect:/admin/price/prices";
	}
}
