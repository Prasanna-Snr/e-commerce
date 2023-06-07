package com.spring.myProject.service;

import java.util.List;

import com.spring.myProject.model.Product;

public interface IproductService {
	
	void addProduct(Product product);
	void deleteProduct(int id);
	Product getById(int id);
	void updateProduct(Product product);
	List<Product> getAllProduct();

}
