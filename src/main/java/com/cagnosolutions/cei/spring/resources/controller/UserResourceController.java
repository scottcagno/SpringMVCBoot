package com.cagnosolutions.cei.spring.resources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cagnosolutions.cei.spring.resources.UserResource;
import com.cagnosolutions.cei.spring.resources.UserResourceAssembler;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
@RequestMapping("/users")
public class UserResourceController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResourceAssembler resourceAssembler;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<UserResource> getUsers() {
		return resourceAssembler.toResources(userService.findAll());
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserResource getUser(@PathVariable("userId") Long id) {
		return resourceAssembler.toResource(userService.findById(id));
	}
	
}
