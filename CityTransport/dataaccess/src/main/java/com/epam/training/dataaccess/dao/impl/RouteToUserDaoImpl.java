package com.epam.training.dataaccess.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.RouteToUserDao;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.RouteToUser;

@Repository
public class RouteToUserDaoImpl implements RouteToUserDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void insert(RouteToUser routeRoUser) {
		try {
			jdbcTemplate.update("INSERT INTO route_2user (route_id,stop_id) VALUES(?,?)",
					routeRoUser.getRouteId(), routeRoUser.getUserId());
		} catch (DataAccessException e) {
		}

	}

	@Override
	public void deleteEntry(Long routeId, Long userId) {
		jdbcTemplate.update("DELETE FROM route_2user WHERE route_id = ? AND user_id = ?",
				routeId, userId);

	}

	@Override
	public List<Route> getUserFavorite(Long id) {
		return jdbcTemplate.query(
				"SELECT * FROM route r WHERE r.id in ( "
						+ "SELECT r2u.route_id FROM route_2user r2u WHERE r2u.user_id  = ?)",
				new Object[] { id }, new BeanPropertyRowMapper<Route>(Route.class));
	}

}
