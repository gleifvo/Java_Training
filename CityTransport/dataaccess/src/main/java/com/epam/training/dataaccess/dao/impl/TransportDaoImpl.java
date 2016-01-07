package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.TransportDao;
import com.epam.training.dataaccess.dao.generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Transport;

@Repository
public class TransportDaoImpl extends GenericDaoImpl<Transport>implements TransportDao {

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
	public void deleteByRegistrationNumber(String regNumber) {
		jdbcTemplate.update(
				"DELETE FROM " + tableName + "  WHERE registration_number = ?",
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

	@Override
	protected Map<String, Object> getParametersForInsert(Transport object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("registration_number", object.getRegistrationNumber());
		parameters.put("type_id", object.getTypeId());
		parameters.put("route_id", object.getRouteId());

		return parameters;
	}
}
