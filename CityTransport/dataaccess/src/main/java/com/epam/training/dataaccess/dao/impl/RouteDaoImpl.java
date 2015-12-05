package com.epam.training.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;

@Repository
public class RouteDaoImpl extends GenericDaoImpl<Route>implements RouteDao {

	public RouteDaoImpl() {
		super();
		tableName = "route";
	}

	@Override
	public Long insert(final Route route) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName + "  (interval) VALUES (?)",
						new String[] { "id" });
				ps.setInt(1, route.getInterval());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Route route) {
		jdbcTemplate.update("UPDATE " + tableName + "  SET interval = ? WHERE  id = ?",
				route.getInterval(), route.getId());
	}

	@Override
	public List<Stop> getStops(Route route) {
		return jdbcTemplate.query(
				"SELECT * FROM stop S " + "WHERE  S.id in "
						+ "( SELECT r2s.stop_id FROM route_2stop r2s"
						+ " WHERE  r2s.route_id in ( SELECT R.id FROM route R"
						+ " WHERE R.id = ?))",
				new Object[] { route.getId() }, new BeanPropertyRowMapper<Stop>(Stop.class));
	}

}
