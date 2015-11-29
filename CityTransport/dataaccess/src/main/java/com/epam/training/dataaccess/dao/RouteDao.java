package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.Route;

public interface RouteDao extends GenericDaoInterface<Route> {

	Long insert(Route route);

	void update(Route route);

	List<Route> getAll();
}
