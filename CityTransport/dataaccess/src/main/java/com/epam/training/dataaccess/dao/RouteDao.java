package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.dao.generic.GenericDao;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;

public interface RouteDao extends GenericDao<Route> {

	List<Stop> getStops(Route route);

}
