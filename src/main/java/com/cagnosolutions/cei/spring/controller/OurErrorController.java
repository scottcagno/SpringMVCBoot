//package com.cagnosolutions.cei.spring.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

//
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/error")
//public class ErrorController {
//	
//	public String error(HttpServletRequest request, Model model) {
//		model.addAttribute("code", request.getAttribute("javax.servlet.error.status_code"));
//		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
//		String message = null;
//		if (throwable != null) {
//			message = throwable.getMessage();
//		}
//		model.addAttribute("message", message.toString());
//		return "error";
//	}
//
//}
//
//@Controller
//@RequestMapping("/error")
//public class OurErrorController {
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String error(HttpServletRequest r, Model model) {
//		model.addAttribute("t", "TIME");
//		model.addAttribute("e", "EXCEPTION");
//		model.addAttribute("u", r.getRequestURI());
//		return "error";
//	}
//}
