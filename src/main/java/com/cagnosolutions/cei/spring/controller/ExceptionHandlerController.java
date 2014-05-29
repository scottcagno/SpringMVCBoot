package com.cagnosolutions.cei.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	public static final String DEFAULT_ERROR_VIEW = "exception";
	
	@ExceptionHandler(value={Exception.class, RuntimeException.class, HTTPException.class})
	public ModelAndView errorHandler(HttpServletRequest r, Exception e) {
		ModelAndView view = new ModelAndView(DEFAULT_ERROR_VIEW);
		view.addObject("t", new Date());
		view.addObject("e", e.getStackTrace()[0]);
		view.addObject("u", r.getRequestURI());
		return view;
	}
}
