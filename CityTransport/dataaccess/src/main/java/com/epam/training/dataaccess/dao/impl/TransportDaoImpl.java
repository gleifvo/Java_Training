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

import com.epam.training.dataaccess.dao.TransportDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Transport;

@Repository
public class TransportDaoImpl extends GenericDaoImpl<Transport> implements TransportDao {

	public TransportDaoImpl() {
		super();
		tableName = "transport";
	}

	@Override
	public Transport getByRegistryNumber(String number) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + "  where registration_number = ?",
				new Object[] { number },
				new BeanPropertyRowMapper<Transport>(Transport.class));
	}

	@Override
	public Long insert(final Transport transport) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName + "  (registration_number,type_id,route_id) VALUES (?,?,?)",
						new String[] { "id" });

				ps.setString(1, transport.getRegistrationNumber());
				ps.setLong(2, transport.getTypeId());
				ps.setLong(3, transport.getRouteId());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Transport transport) {
		jdbcTemplate.update(
				"UPDATE " + tableName + "  SET registration_number = ?, type_id = ?, route_id = ? WHERE  id = ?",
				transport.getRegistrationNumber(), transport.getTypeId(),
				transport.getRouteId(), transport.getId());
	}

	@Override
	public void deleteByRegistrationNumber(String regNumber) {
		jdbcTemplate.update("DELETE FROM " + tableName + "  WHERE registration_number = ?",
				regNumber);
	}

	@Override
	public List<Transport> getByRouteId(Long id) {
		return jdbcTemplate.query("SELECT * FROM " + tableName + "  WHERE route_id = ?",
				new Object[] { id },
				new BeanPropertyRowMapper<Transport>(Transport.class));

	}

	@Override
	public List<Transport> getByTypeId(Long id) {
		return jdbcTemplate.query("SELECT * FROM " + tableName + "  where type_id = ?",
				new Object[] { id },
				new BeanPropertyRowMapper<Transport>(Transport.class));
	}
}
