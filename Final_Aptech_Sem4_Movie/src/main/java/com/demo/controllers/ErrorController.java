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

import com.demo.models.Account;
import com.demo.models.Usertype;
import com.demo.services.AccountService;
import com.demo.services.MovieService;
import com.demo.services.TicketService;
import com.demo.services.UserTypeService;



@Controller
@RequestMapping("error")
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
	
	@RequestMapping(value = "404", method = RequestMethod.GET)
	public String login(ModelMap modelMap,@RequestParam(value = "error", required = false) String error) {
		return "404/404";
	}
	
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "404/404";
    }
	
}
