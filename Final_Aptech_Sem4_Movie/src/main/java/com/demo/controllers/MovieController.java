package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"movie"})
public class MovieController {
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.put("p", "../movie/index.jsp");
		return "layouts/index";
	}
}
