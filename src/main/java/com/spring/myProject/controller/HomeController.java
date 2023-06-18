package com.spring.myProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.myProject.model.Category;
import com.spring.myProject.service.IcategoryService;

@Controller
public class HomeController {
	
	
	@Autowired
	private IcategoryService servic;
	
	
	@GetMapping("/home")
	public String getHomePage() {
		return "Home";
	}
	
	
	@GetMapping("/shopCategory")
	public String shopCategory() {
		return "shopCategory";
	}
	
	@GetMapping("/singleProduct")
	public String singleProduct() {
		return"single-product";
	}
	
	
	

}
