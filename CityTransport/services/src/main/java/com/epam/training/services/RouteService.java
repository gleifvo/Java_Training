package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Route;

public interface RouteService {

	void addRoute(Route route);
	
	void updateRoute(Route route);

	Route getRouteByNumber(Long id);
	
	void deleteRouteByNumber(Long id);
	
	List<Route> getAll();
}
