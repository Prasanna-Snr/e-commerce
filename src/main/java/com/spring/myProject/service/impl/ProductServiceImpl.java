package com.spring.myProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myProject.model.Product;
import com.spring.myProject.repository.ProductRepository;
import com.spring.myProject.service.IproductService;
@Service
public class ProductServiceImpl implements IproductService{
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public Product getById(int id) {
		
		return productRepo.getById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

}
