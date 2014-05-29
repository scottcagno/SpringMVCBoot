package com.cagnosolutions.cei.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cagnosolutions.cei.spring.domain.Account;
import com.cagnosolutions.cei.spring.service.AccountService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String registerGetHandler(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerPostHandler(@RequestParam(value="confirm", required=true) String confirm, @Valid Account newAccount) {
		if (newAccount.getUser().getPassword().equals(confirm)) {
			accountService.insert(newAccount);
			return "redirect:/home";
		} else {
			return "redirect:/register?pass"; 
		}
	}
	
}
