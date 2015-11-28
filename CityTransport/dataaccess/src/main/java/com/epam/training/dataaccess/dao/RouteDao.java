package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.Route;

public interface RouteDao {

	Route getById(Long id);

	Long insert(Route route);

	void update(Route route);
	
	void delete(Long id);
	
	List<Route> getAll();
}
