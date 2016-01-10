package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;

public interface RouteService {

	void addRoute(Route route);
	
	void updateRoute(Route route);

	Route getRouteByNumber(Long id);
	
	void deleteRouteByNumber(Long id);
	
	List<Route> getAll();
	
	List<Stop> getStops(Route route);

	List<Route> getAll(long first, long count, String field, String order);

	Integer getCountRoutes();

	void addStop(Long routeId, Long stopId);

	void deleteStop(Long routeId, Long stopId);
}
