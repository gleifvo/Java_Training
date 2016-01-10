package com.epam.training.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.dao.RouteToStopDao;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.RouteToStop;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private RouteToStopDao routeToStopDao;

	@Override
	public Route getRouteByNumber(Long id) {
		return routeDao.getById(id);
	}

	@Override
	public void deleteRouteByNumber(Long id) {

		routeDao.deleteById(id);
		LOGGER.info(new SimpleDateFormat().format(new Date().getTime()) + " Route number "
				+ id + " deleted");
	}

	@Override
	public void addRoute(Route route) {
		route.setId(routeDao.insert(route));
		LOGGER.info(new SimpleDateFormat().format(new Date().getTime()) + " Route number "
				+ route.getId() + " added");
	}

	@Override
	public void updateRoute(Route route) {
		routeDao.update(route);
		LOGGER.info(new SimpleDateFormat().format(new Date().getTime()) + " "
				+ route.toString() + " updated");
	}

	@Override
	public List<Route> getAll() {
		return routeDao.getAll();
	}

	@Override
	public List<Route> getAll(long first, long count, String field, String order) {
		return routeDao.getAll(first, count, field, order);
	}

	@Override
	public List<Stop> getStops(Route route) {
		return routeDao.getStops(route);
	}

	@Override
	public Integer getCountRoutes() {
		return routeDao.getCount();
	}

	@Override
	public void addStop(Long routeId,Long stopId) {
		RouteToStop routeToStop = new RouteToStop(routeId,stopId);
		routeToStopDao.insert(routeToStop);
	}
	
	@Override
	public void deleteStop(Long routeId, Long stopId) {
		routeToStopDao.deleteEntry(stopId, routeId);
	}
}
