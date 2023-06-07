package com.spring.myProject.service;

import java.util.List;

import com.spring.myProject.model.Category;

public interface IcategoryService {
	void addCategory(Category cat);
	
	void deleteCat(int id);
	
	Category getById(int id);
	
	void updateCategorr(Category cate);
	
	List<Category> getAllCategory();

}
