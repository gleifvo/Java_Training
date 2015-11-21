package com.epam.training.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.dataaccess.model.Route;

public final class RouteMapper implements RowMapper<Route> {
	
	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Route route = new Route();
		
		route.setId(rs.getLong("id"));
		
		route.setInterval(rs.getInt("interval"));
		
		return route;
	}
}