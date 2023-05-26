package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.AccountHolder;
import com.ab.services.AccountHolderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.ab.services.AccountHolderService;

@Controller
public class AccountHolderController {

	@Autowired
	private AccountHolderService accountHolderService;
	
	
	@RequestMapping(value="/",method = RequestMethod.GET )
	public String landing() {
		return "home";
	}
	
	@GetMapping("/registerPage")
	public String registerForm() {
		return "register";
	}
	

	@PostMapping("/registerPage")
	public String registerProcess(@ModelAttribute AccountHolder accountHolder) {

		AccountHolder registeredCustomer = this.accountHolderService.saveAccountHolder(accountHolder);

		if(registeredCustomer != null) {
			return "home";
		}
		else {
			return "reg_failure";
		}
	}

	@PostMapping("/login")
	public String loginProcess(String username, String password, HttpServletRequest request) {

		AccountHolder loggedInCustomer = this.accountHolderService.loginAccountHolder(username, password);


		if(loggedInCustomer != null) {


			HttpSession session = request.getSession(true);


			session.setAttribute("loggedInCustomer", loggedInCustomer);



			return "welcome";
		}
		else {
			return "login";
		}
	}
	
	
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "welcome";
	}

	

}
