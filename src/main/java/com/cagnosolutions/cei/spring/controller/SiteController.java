package com.cagnosolutions.cei.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cagnosolutions.cei.spring.domain.Account;
import com.cagnosolutions.cei.spring.domain.Users;
import com.cagnosolutions.cei.spring.service.AccountService;

@Controller
public class SiteController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/insert")
	public void testHandler() {
		Account account = new Account(new Users("gregpechiro", "testing"), "Greg");
		accountService.insert(account);
	}
	
	@RequestMapping("/pull")
	public String pullHandler(Model model, HttpServletRequest r) {
		model.addAttribute("account", accountService.findByUsername("gregpechiro"));
		model.addAttribute("url", "The URI is " + r.getRequestURI());
		model.addAttribute("address", "Address is " + r.getRemoteAddr());
		return "test";
	}
	
	@RequestMapping({"/", "/index"})
	public String indexHandler() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String welcomeHandler() {
		return "home";
	}
	
	@RequestMapping("/admin")
	public String adminHandler() {
		return "admin/admin";
	}
	
	@Bean(name="error")
	@RequestMapping("/error")
	public String error(HttpServletRequest r, Model model) {
		model.addAttribute("t", "TIME");
		model.addAttribute("e", "EXCEPTION");
		model.addAttribute("u", r.getRequestURI());
		return "error";
	}
}
