package com.cagnosolutions.cei.spring.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.resources.controller.UserResourceController;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

	public UserResourceAssembler() {
		super(UserResourceController.class, UserResource.class);
		
	}

	@Override
	public UserResource toResource(User user) {
		UserResource resource = createResourceWithId(user.getId(), user);
		return resource;
	}
	
	protected UserResource instantiateResource(User user) {
		return new UserResource(user);
	}

}
