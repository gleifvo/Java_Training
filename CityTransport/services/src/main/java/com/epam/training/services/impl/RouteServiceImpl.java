package com.epam.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.services.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;

	@Override
	public void insertOrUpdate(Route route) {
		if (route.getId() == null) {
			routeDao.insert(route);
		} else {
			routeDao.update(route);
		}
	}

	@Override
	public Route get(Long id) {
		return routeDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		routeDao.delete(id);
	}
}
