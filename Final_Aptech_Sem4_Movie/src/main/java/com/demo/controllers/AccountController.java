package com.demo.controllers;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.demo.models.ResetPassword;
import com.demo.models.Usertype;
import com.demo.services.AccountService;
import com.demo.services.MailService;
import com.demo.services.MovieService;
import com.demo.services.TicketService;
import com.demo.services.UserTypeService;



@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserTypeService userTypeService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap,@RequestParam(value = "error", required = false) String error) {
		if(error != null) {
			modelMap.put("msg", "Invalid");
		}
		return "account/login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		return "account/register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account) {
		String hash = encoder.encode(account.getPassword().trim());
		account.setPassword(hash);
		Usertype usertype = userTypeService.find(2);
		account.setUsertype(usertype);
		accountService.save(account);
		String content = "Username: " + account.getUsername() + " has been created.";
		try {
			mailService.send(environment.getProperty("spring.mail.username"), account.getEmail(), "Create Successfully", content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/login";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(ModelMap modelMap,  Authentication authentication) {
		modelMap.put("account", accountService.findByUsername(authentication.getName()));
		return "account/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("account") Account account, RedirectAttributes redirectAttributes) {
		try {
			String hash = encoder.encode(account.getPassword().trim());
			account.setPassword(hash);
			Usertype usertype = userTypeService.find(2);
			account.setUsertype(usertype);
			accountService.save(account);
			String content = "Username: " + account.getUsername() + " has been edited.";
			try {
				mailService.send(environment.getProperty("spring.mail.username"), account.getEmail(), "Edit Successfully", content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			redirectAttributes.addFlashAttribute("msg", "Update Successfully");
			return "redirect:/account/edit";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "Update Failed");
			return "redirect:/account/edit";
		}
	}
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.GET)
	public String reset_password(ModelMap modelMap,  Authentication authentication) {
		ResetPassword resetPassword = new ResetPassword();
		modelMap.put("resetPassword", resetPassword);
		return "account/resetpassword";
	}
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public String reset_password(Authentication authentication,@ModelAttribute("resetPassword") ResetPassword resetPassword, RedirectAttributes redirectAttributes) {

		try {

			try {

				Account account = accountService.findByUsername(resetPassword.getUsername());

				if (!resetPassword.getConfirmPassword().equals(resetPassword.getPassword())) {
					redirectAttributes.addFlashAttribute("msg", "Password does not match");
					return "redirect:/account/resetPassword";
				} else {
					String hash = encoder.encode(resetPassword.getPassword().trim());
					account.setPassword(hash);
					Usertype usertype = userTypeService.find(2);
					account.setUsertype(usertype);
					accountService.save(account);
					String content = "Password of " + account.getUsername() + " has been reseted";
					try {
						mailService.send(environment.getProperty("spring.mail.username"), account.getEmail(), "Reset Password Successfully", content);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					redirectAttributes.addFlashAttribute("msg", "Reset Password Successfully");
					return "redirect:/account/resetPassword";
				}

			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("msg", "Username does not exist");
				return "redirect:/account/resetPassword";
			}
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "Reset Password Failed");
			return "redirect:/account/resetPassword";
		}
	}
	
	@RequestMapping(value = "history", method = RequestMethod.GET)
	public String history(ModelMap modelMap, Authentication authentication) {
		Account account = accountService.findByUsername(authentication.getName());
		modelMap.put("tickets", ticketService.findAllByUserId(account.getId()));
		return "account/history";
	}
	
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "account/accessDenied";
	}
	
}
