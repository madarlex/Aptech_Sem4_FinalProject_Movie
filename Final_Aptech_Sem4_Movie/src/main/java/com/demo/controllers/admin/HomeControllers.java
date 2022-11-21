package com.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("AdminHomeController")
@RequestMapping({"admin/home", "admin"})
public class HomeControllers {
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.put("p", "../home/index.jsp");
		return "admin/layouts/index";
	}
}
