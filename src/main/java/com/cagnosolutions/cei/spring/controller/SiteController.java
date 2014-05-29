package com.cagnosolutions.cei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cagnosolutions.cei.spring.service.AccountService;

@Controller
public class SiteController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/index")
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
}
