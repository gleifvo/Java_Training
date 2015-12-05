package com.epam.training.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.TransportToDriverDao;
import com.epam.training.dataaccess.model.TransportToDriver;

@Repository
public class TransportToDriverDaoImpl implements TransportToDriverDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public void insert(final TransportToDriver transportToDriver) {
		jdbcTemplate.update(
				"INSERT INTO transport_2driver (driver_id,transport_id) VALUES(?,?)",
				transportToDriver.getDriverId(), transportToDriver.getTransportId());
	}

}
