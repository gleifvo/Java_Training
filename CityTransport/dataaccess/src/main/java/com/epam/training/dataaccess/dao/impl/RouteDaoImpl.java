package com.epam.training.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.dao.mapper.RouteMapper;
import com.epam.training.dataaccess.model.Route;

@Repository
public class RouteDaoImpl implements RouteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Route getById(Long id) {
		return jdbcTemplate.queryForObject("select * from \"routes\" where id = ?",
				new Object[] { id }, new RouteMapper());
	}

	@Override
	public void insert(Route route) {
		jdbcTemplate.update("INSERT INTO \"routes\" (Interval) VALUES (?)",
				route.getInterval());
	}

	@Override
	public void update(Route route) {
		jdbcTemplate.update("UPDATE routes SET interval = ? WHERE  id = ?",
				route.getInterval(),route.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM routes WHERE id = ?",
				id);		
	}
}
