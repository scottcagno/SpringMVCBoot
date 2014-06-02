package com.cagnosolutions.cei.spring.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> allUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	@ResponseBody
	public User getNewUser() {
		return new User();
	}
	
//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	@ResponseBody
//	public Object postNewUser(
//			@RequestParam(value="email", required = true) String email,
//			@RequestParam(value="enabled", required = true) short enabled,
//			@RequestParam(value="confirm", required = true) String confirm, 
//			@RequestParam(value="password", required = true) String password, 
//			@RequestParam(value="username", required = true) String username,
//			@RequestParam(value="userGroup", required = true) String userGroup) {
//	
//		if (password.equals(confirm) && !userService.exists(username)) {
//			User user = new User(username, password, enabled, userGroup, email);
//			return userService.insert(user);
//		}
//		return new HashMap<String, String>() {{put("error","problem inserting user");}};
//	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public Object postNewUser(@RequestBody User user) {
		if (!userService.exists(user.getUsername()))
			return userService.insert(user);
		return new HashMap<String, String>() {{put("error","problem inserting user");}};
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User showUser(@PathVariable(value="id") Long id) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(@PathVariable(value="id") Long id) {
		userService.delete(userService.findById(id));
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object postEditUser(@RequestBody User user, @RequestParam(value="confirm") String confirm) {
		if (user.getPassword().equals(confirm) && userService.exists(user.getUsername()))
			return userService.insert(user);
		return new HashMap<String, String>() {{put("error","problem updating user");}};
	}
}
