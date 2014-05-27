package com.cagnosolutions.cei.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping("/auth")
	public String loginHandler() {
		return "auth";
	}
}