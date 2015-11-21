package com.epam.training.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.dataaccess.dao.TransportTypeDao;
import com.epam.training.dataaccess.dao.mapper.TransportTypeMapper;
import com.epam.training.dataaccess.model.TransportType;

public class TransportTypeDaoImpl implements TransportTypeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public TransportType getById(Long id) {
		return jdbcTemplate.queryForObject("select * from transport_type where id = ?",
				new Object[] { id }, new TransportTypeMapper());

	}

	@Override
	public void insert(TransportType transportType) {
		jdbcTemplate.update(
				"INSERT INTO transport_type (transport_type,capacity,max_speed) VALUES (?,?,?)",
				transportType.getType(), transportType.getCapacity(),
				transportType.getMaxSpeed());
	}

	@Override
	public void update(TransportType transportType) {
		jdbcTemplate.update(
				"UPDATE transport_type SET transport_type = ?  capacity = ? max_speed = ? WHERE  id = ?",
				transportType.getType(), transportType.getCapacity(),
				transportType.getMaxSpeed(), transportType.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM transport_type WHERE id = ?", id);
	}
}
