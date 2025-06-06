package com.mymart.mymart.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "custom-login";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied";
	}

}
