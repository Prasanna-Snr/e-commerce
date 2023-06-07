package com.spring.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.myProject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
