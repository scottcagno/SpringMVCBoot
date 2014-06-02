package com.cagnosolutions.cei.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ResponseBody
	@ExceptionHandler(value={Exception.class, RuntimeException.class, HTTPException.class})
	public String errorHandler(HttpServletRequest r, Exception e) {
		return r.getAttribute("javax.servlet.error.message").toString();
	}
}
