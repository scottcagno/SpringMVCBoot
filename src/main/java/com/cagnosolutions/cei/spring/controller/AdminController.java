package com.cagnosolutions.cei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cagnosolutions.cei.spring.domain.Account;
import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.AccountService;

@Controller
public class AdminController {
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping("/admin/editAccount")
	public String editAccount(@RequestParam(value="id", required=true) Long id, Model model) {
		model.addAttribute("account", accountService.findById(id));
		return "admin/editAccount";
	}
	
	@RequestMapping("/admin/updateAccount")
	public String updateAccount(
			@RequestParam(value="id", required=true) Long id,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="enabled", required=true) Short enabled,
			@RequestParam(value="userGroup", required=true) String userGroup) {
		
		Account account = accountService.findById(id);
		account.getUser().setEnabled(enabled);
		account.setName(name);
		account.getUser().setUserGroup(userGroup);
		accountService.update(account);
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value="/admin/addAccount", method=RequestMethod.GET)
	public String addAccountGetHandler() {
		return "admin/addAccount";
	}
	
	@RequestMapping(value="/admin/addAccount", method=RequestMethod.POST)
	public String addAccountPostHandler(
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="enabled", required=true) Short enabled,
			@RequestParam(value="confirm", required=true) String confirm,
			@RequestParam(value="password", required=true) String password,
			@RequestParam(value="username", required=true) String username,	
			@RequestParam(value="userGroup", required=true) String userGroup) {
		
		if (password.equals(confirm)) {
			Account account = new Account(new User(username, password, enabled, userGroup), name);
			accountService.insert(account);
			return "redirect:/admin/home";
		} else {
			return "redirect:/admin/addAccount?pass";
		}
	}
}
