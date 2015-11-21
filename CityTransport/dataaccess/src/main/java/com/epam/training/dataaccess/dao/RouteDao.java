package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.Route;

public interface RouteDao {

	Route getById(Long id);

	void insert(Route route);

	void update(Route route);
	
	void delete(Long id);
}
