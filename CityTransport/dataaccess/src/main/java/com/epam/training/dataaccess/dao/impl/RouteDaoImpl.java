package com.epam.training.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.model.Route;

@Repository
public class RouteDaoImpl extends GenericDao<Route>implements RouteDao {

	public RouteDaoImpl() {
		super();
		tableName = "routes";
	}

	@Override
	public Long insert(final Route route) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO routes (interval) VALUES (?)",
						new String[] { "id" });
				ps.setInt(1, route.getInterval());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Route route) {
		jdbcTemplate.update("UPDATE routes SET interval = ? WHERE  id = ?",
				route.getInterval(), route.getId());
	}

}
