package com.epam.training.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.StopDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Stop;

@Repository
public class StopDaoImpl extends GenericDaoImpl<Stop>implements StopDao {

	public StopDaoImpl() {
		super();
		tableName = "stop";
	}

	@Override
	public Long insert(final Stop stop) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName + "  (name) VALUES (?)",
						new String[] { "id" });
				ps.setString(1, stop.getName());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Stop stop) {
		jdbcTemplate.update("UPDATE " + tableName + "  SET name = ? WHERE  id = ?",
				stop.getName(), stop.getId());
	}

}
