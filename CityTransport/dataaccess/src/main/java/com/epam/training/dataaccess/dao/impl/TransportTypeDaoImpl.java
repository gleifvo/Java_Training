package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.TransportTypeDao;
import com.epam.training.dataaccess.dao.generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.TransportType;

@Repository
public class TransportTypeDaoImpl extends GenericDaoImpl<TransportType>
		implements TransportTypeDao {

	public TransportTypeDaoImpl() {
		super();
		tableName = "transport_type";
	}

	@Override
	public TransportType getByTypeName(String name) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + " WHERE transport_type = ?",
				new Object[] { name },
				new BeanPropertyRowMapper<TransportType>(TransportType.class));
	}


	@Override
	public Long getIdByType(String type) {
		TransportType transportType = jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + "  WHERE transport_type = ?",
				new Object[] { type },
				new BeanPropertyRowMapper<TransportType>(TransportType.class));

		return transportType.getId();
	}
	
	@Override
	public String getTypeById(Long id) {
		TransportType transportType = jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + "  WHERE id = ?",
				new Object[] { id },
				new BeanPropertyRowMapper<TransportType>(TransportType.class));

		return transportType.getTransportType();
	}

	@Override
	public String toString() {
		return "TransportTypeDaoImpl [jdbcTemplate=" + jdbcTemplate + "]";
	}

	@Override
	protected Map<String, Object> getParametersForInsert(TransportType object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("transport_type", object.getTransportType());
		parameters.put("capacity", object.getCapacity());
		parameters.put("max_speed", object.getMaxSpeed());

		return parameters;
	}


}
