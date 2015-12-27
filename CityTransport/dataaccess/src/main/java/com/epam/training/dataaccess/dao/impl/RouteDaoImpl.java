package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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



	@Override
	protected Map<String, Object> getParametersForInsert(Route entity) {
	     Map<String, Object> parameters = new HashMap<>();
	        parameters.put("interval", entity.getInterval());
	        return parameters;
	}

}
