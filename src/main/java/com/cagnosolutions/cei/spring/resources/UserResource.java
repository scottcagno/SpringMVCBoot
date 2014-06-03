package com.cagnosolutions.cei.spring.resources;

import org.springframework.hateoas.ResourceSupport;

import com.cagnosolutions.cei.spring.domain.User;

public class UserResource extends ResourceSupport {
	
	private User user;
	
	public UserResource() {}
	
	public UserResource(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
