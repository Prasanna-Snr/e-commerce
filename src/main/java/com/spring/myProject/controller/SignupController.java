package com.spring.myProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.myProject.model.User;

import com.spring.myProject.service.IuserService;



@Controller
public class SignupController {
	
	@Autowired
	private IuserService service;
	
	@GetMapping("/signup")
	public String getSignupForm() {
		return "SignUpForm";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		user.setPsw(DigestUtils.md5DigestAsHex(user.getPsw().getBytes()));
		
		service.addUser(user);
		return "LoginForm";
	}
	
}
