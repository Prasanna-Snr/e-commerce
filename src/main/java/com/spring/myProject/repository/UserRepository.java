package com.spring.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.myProject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUnameAndPsw(String un,String psw);

}
