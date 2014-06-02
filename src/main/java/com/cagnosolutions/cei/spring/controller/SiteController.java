package com.cagnosolutions.cei.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cagnosolutions.cei.spring.domain.Account;
import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.AccountService;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
public class SiteController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/insert")
	public String testHandler() {
		Account account = new Account(new User("username", "password"), "Greg");
		accountService.insert(account);
		return "redirect:/home";
	}
	
//	@RequestMapping("update")
//	public String updateHandler() {
//		User user = userService.findById("username");
//		user.setUsername("user");
//		userService.update(user);
//		return "redirect:/admin/home";
//	}
	
	@RequestMapping("/pull")
	public String pullHandler(Model model, HttpServletRequest r) {
		model.addAttribute("account", accountService.findByUsername("username"));
		model.addAttribute("url", "The URI is " + r.getRequestURI());
		model.addAttribute("address", "Address is " + r.getRemoteAddr());
		return "test";
	}
	
	@RequestMapping("/")
	public String rootHandler() {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String indexHandler() {
		return "home";
	}
	
	@RequestMapping("/user/home")
	public String welcomeHandler() {
		return "home";
	}
	
	@RequestMapping("/admin/home")
	public String adminHandler(Model model) {
		model.addAttribute("accountList", accountService.findAll());
		return "admin/admin";
	}
}
