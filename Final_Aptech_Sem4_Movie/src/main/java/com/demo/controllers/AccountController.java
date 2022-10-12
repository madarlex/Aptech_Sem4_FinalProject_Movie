package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"account"})
public class AccountController {
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.put("p", "../home/index.jsp");
		return "layouts/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.GET)
	public String add (ModelMap modelMap) {
		modelMap.put("p", "../account/register.jsp");
		return "layouts/index";
	}
	
	@RequestMapping(value = {"accounts"}, method = RequestMethod.GET)
	public String list (ModelMap modelMap) {
		modelMap.put("p", "../account/accounts.jsp");
		return "layouts/index";
	}
}
