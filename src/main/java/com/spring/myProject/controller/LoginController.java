package com.spring.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.myProject.model.User;
import com.spring.myProject.repository.UserRepository;


@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user,Model model) {
		user.setPsw(DigestUtils.md5DigestAsHex(user.getPsw().getBytes()));
	User usr= userRepo.findByUnameAndPsw(user.getUname(), user.getPsw());
		if(usr != null) {
			
			model.addAttribute("username",user.getUname());
			return "UserIndex";
		}
		
		model.addAttribute("message","user not found!!!");
		return "LoginForm";
	}
	
}
