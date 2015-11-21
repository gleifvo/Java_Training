package com.epam.training.services;

import com.epam.training.dataaccess.model.Route;

public interface RouteService {

	void insertOrUpdate(Route route);

	Route get(Long id);
	
	void delete(Long id);
}
