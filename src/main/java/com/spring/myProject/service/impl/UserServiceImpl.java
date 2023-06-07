package com.spring.myProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myProject.model.User;
import com.spring.myProject.repository.UserRepository;
import com.spring.myProject.service.IuserService;
@Service
public class UserServiceImpl implements IuserService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public void addUser(User usr) {
		userRepo.save(usr);
	}

}
