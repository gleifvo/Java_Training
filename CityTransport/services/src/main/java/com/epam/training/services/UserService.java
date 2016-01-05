package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.User;

public interface UserService {
	
	boolean authenticate(String login,String password);
	
	void registrationUser(User user);
	
	List<User> getAll();

}
