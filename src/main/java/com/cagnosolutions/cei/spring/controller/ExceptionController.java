package com.cagnosolutions.cei.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler(value={Exception.class, RuntimeException.class})
	public ModelAndView errorHandler(HttpServletRequest r, Exception e) {
		ModelAndView view = new ModelAndView(DEFAULT_ERROR_VIEW);
		view.addObject("timestamp", new Date());
		view.addObject("error", e.getMessage());
		view.addObject("url", r.getRequestURI());
		return view;
	}

}
