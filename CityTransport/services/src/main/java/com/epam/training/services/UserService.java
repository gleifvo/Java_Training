package com.epam.training.services;

import com.epam.training.dataaccess.model.User;

public interface UserService {
	
	boolean authenticate(String login,String password);
	
	void registrationUser(User user);

}
