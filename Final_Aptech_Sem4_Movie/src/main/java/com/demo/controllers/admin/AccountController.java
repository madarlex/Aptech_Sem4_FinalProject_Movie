package com.demo.controllers.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
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

import com.demo.models.Account;
import com.demo.models.Movie;
import com.demo.models.Usertype;
import com.demo.services.admin.AccountService;
import com.demo.services.admin.UserTypeService;

@Controller("AdminAccountController")
@RequestMapping({"admin/account"})
public class AccountController{
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserTypeService userTypeService;
	private int currPage;
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.put("p", "../home/index.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.GET)
	public String add (ModelMap modelMap) {
		modelMap.put("types", userTypeService.findAll());
		modelMap.put("account", new Account());
		modelMap.put("p", "../account/register.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"add"}, method = RequestMethod.POST)
	public String add (ModelMap modelMap,@ModelAttribute("account") Account account,@RequestParam("type")int type) {
		Usertype ut = new Usertype();
		ut.setId(type);
		account.setStatus(true);
		account.setUsertype(ut);
		account.setPassword(BCrypt.hashpw(account.getPassword().trim(), BCrypt.gensalt()));
		if(accountService.create(account)) {
			System.out.println("Done");
		}else {
			System.out.println("Failed");
		}
		return "redirect:/admin/account/accounts";
	}
	
	@RequestMapping(value = {"edit/{id}"}, method = RequestMethod.GET)
	public String add (ModelMap modelMap,@PathVariable("id")int id) {
		Account a = accountService.findById(id);
		a.setPassword("");
		modelMap.put("account", a);
		modelMap.put("p", "../account/edit.jsp");
		return "admin/layouts/index";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.POST)
	public String add (ModelMap modelMap,@ModelAttribute("account")Account account) {
		Account a = accountService.findById(account.getId());
		if(account.getPassword()!= null) {
			a.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
		}
		a.setUsername(account.getUsername());
		a.setFullName(account.getFullName());
		a.setEmail(account.getEmail());
		a.setPhone(account.getPhone());
		a.setStatus(account.isStatus());
		accountService.create(a);
//		modelMap.put("account", a);
//		modelMap.put("p", "../account/edit.jsp");
//		return "layouts/index";
		return "redirect:/admin/account/accounts";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete (ModelMap modelMap,@PathVariable("id")int id) {
		Account a = accountService.findById(id);
		a.setStatus(false);
		accountService.create(a);
		return "redirect:/admin/account/accounts";
	}
	
	
	@RequestMapping(value = {"accounts"}, method = RequestMethod.GET)
	public String list (ModelMap modelMap,HttpSession session) {
		modelMap.put("preCheck", "");
		modelMap.put("nextCheck", "");
		return listByPage(modelMap, 1,session);
	}
	
	@GetMapping("/accounts/{pageNumber}")
	public String listByPage (ModelMap modelMap,@PathVariable("pageNumber") int currentPage,HttpSession session) {
		Page<Account> page = accountService.findAll(currentPage);
		List<Account> accounts = page.getContent();
		int totalPage = page.getTotalPages();
		currPage = currentPage;
		modelMap.put("preCheck", currPage == 1 ? "disabled" : " ");
		modelMap.put("nextCheck", currPage == totalPage ? "disabled" : " ");
		session.setAttribute("totalpage", totalPage);
		session.setAttribute("currentPage", currentPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("accounts", accounts);
		modelMap.put("p", "../account/accounts.jsp");
		return "admin/layouts/index";
	}


}
