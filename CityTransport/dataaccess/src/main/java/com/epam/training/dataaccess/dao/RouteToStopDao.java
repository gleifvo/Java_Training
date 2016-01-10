package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.RouteToStop;

public interface RouteToStopDao {

	void insert(final RouteToStop routeToStop);

	void deleteEntry(Long stopId, Long routeId);
}
