package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.User;

public interface UserService {

	boolean authenticate(User user);
	
	String getRole(Long id);

	void registrationUser(User user);
	
	List<Route> getUserRoutes(Long userId);

	List<User> getAll();

	List<User> getAll(long first, long count);
	
	List<User> getAll(long first, long count,String field,String order);

	void addRoute(Long userId, Long routeId);

	void deleteRoute(Long userId, Long routeId);

}
