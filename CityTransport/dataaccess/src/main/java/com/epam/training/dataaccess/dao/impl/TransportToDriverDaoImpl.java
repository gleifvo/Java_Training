package com.epam.training.dataaccess.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.TransportToDriverDao;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.dataaccess.model.TransportToDriver;

@Repository
public class TransportToDriverDaoImpl implements TransportToDriverDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void insert(final TransportToDriver transportToDriver) {
		try {
			jdbcTemplate.update(
					"INSERT INTO transport_2driver (driver_id,transport_id) VALUES(?,?)",
					transportToDriver.getDriverId(), transportToDriver.getTransportId());
		} catch (DataAccessException e) {
		}
	}

	@Override
	public List<Transport> getDriverTransports(Long id) {
		return jdbcTemplate.query(
				"SELECT * FROM transport t WHERE t.id in ( "
						+ "SELECT t2d.transport_id FROM transport_2driver t2d WHERE t2d.driver_id  = ?)",
				new Object[] { id },
				new BeanPropertyRowMapper<Transport>(Transport.class));
	}

	@Override
	public void deleteEntry(Long transportId, Long driverId) {

		jdbcTemplate.update(
				"DELETE FROM transport_2driver WHERE transport_id = ? AND driver_id = ?",
				transportId, driverId);
	}

}
