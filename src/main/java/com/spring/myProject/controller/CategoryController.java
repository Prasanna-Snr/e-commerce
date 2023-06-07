package com.spring.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myProject.model.Category;
import com.spring.myProject.service.IcategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private IcategoryService servic;
	
	@GetMapping("/category")
	public String getCategoryForm(Model model) {
		model.addAttribute("categoryList",servic.getAllCategory());
		return "CategoryForm";
	}
	
	@GetMapping("/addCat")
	public String AddCatForm() {
		return "AddCategroyForm";
	}

	
	@PostMapping("/saveCat")
	public String saveCategory(@ModelAttribute Category cat) {
		servic.addCategory(cat);
		return "redirect:/category";
	}
	
	@GetMapping("/delete")
	public String deleteCat(@RequestParam int id) {
		servic.deleteCat(id);
		return "redirect:/category";
	}
	
	@GetMapping("/edit")
	public String editCate(@RequestParam int id,Model model) {
		model.addAttribute("oldData",servic.getById(id));
		return "EditCategory";
	}
	
	
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute Category cate) {
		servic.updateCategorr(cate);
		return "redirect:/category";
	}
	
	
}
