package com.epam.training.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.RouteToStopDao;
import com.epam.training.dataaccess.model.RouteToStop;

@Repository
public class RouteToStopDaoImpl implements RouteToStopDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void insert(final RouteToStop routeToStop) {
		try {
			jdbcTemplate.update("INSERT INTO route_2stop (route_id,stop_id) VALUES(?,?)",
					routeToStop.getRouteId(), routeToStop.getStopId());
		} catch (DataAccessException e) {
		}

	}

	@Override
	public void deleteEntry(Long stopId, Long routeId) {

		jdbcTemplate.update("DELETE FROM route_2stop WHERE stop_id = ? AND route_id = ?",
				stopId, routeId);
	}

}
