package com.spring.myProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myProject.model.Category;
import com.spring.myProject.repository.CategoryRepository;
import com.spring.myProject.service.IcategoryService;

@Service
public class CategoryServiceImpl implements IcategoryService{
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public void addCategory(Category cat) {
		catRepo.save(cat);
		
	}

	@Override
	public void deleteCat(int id) {
		catRepo.deleteById(id);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return catRepo.findAll();
	}

	@Override
	public Category getById(int id) {
		
		return catRepo.getById(id);
	}

	@Override
	public void updateCategorr(Category cate) {
		catRepo.save(cate);
		
	}

	

}
