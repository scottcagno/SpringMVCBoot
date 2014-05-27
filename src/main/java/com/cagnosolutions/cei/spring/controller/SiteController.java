package com.cagnosolutions.cei.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
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
	
	@RequestMapping("/error.html")
	public String errorHandler(HttpServletRequest request, Model model) {
		model.addAttribute("code", request.getAttribute("javax.servlet.error.status_code"));
		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
		String message = null;
		if (throwable != null) {
			message = throwable.getMessage();
		}
		model.addAttribute("message", message.toString());
		return "error.html";
	}
}
