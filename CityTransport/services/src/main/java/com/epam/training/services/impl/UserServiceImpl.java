package com.epam.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.UserDao;
import com.epam.training.dataaccess.dao.UserTypeDao;
import com.epam.training.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserTypeDao userTypeDao;
	
	@Override
	public boolean authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
