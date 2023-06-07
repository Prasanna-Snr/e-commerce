package com.spring.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.myProject.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
