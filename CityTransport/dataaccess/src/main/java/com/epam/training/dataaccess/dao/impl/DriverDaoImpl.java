package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.DriverDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Driver;

@Repository
public class DriverDaoImpl extends GenericDaoImpl<Driver>implements DriverDao {

	public DriverDaoImpl() {
		super();
		tableName = "driver";
	}

	@Override
	public List<Driver> getDriversByRegNumber(String number) {
		return jdbcTemplate.query("SELECT * FROM driver D " + "WHERE  D.id in "
				+ "( SELECT t2d.driver_id FROM transport_2driver t2d"
				+ " WHERE  t2d.transport_id in " + "( SELECT T.id FROM transport T"
				+ " WHERE T.registration_number = ?))", new Object[] { number },
				new BeanPropertyRowMapper<Driver>(Driver.class));
	}

	@Override
	protected Map<String, Object> getParametersForInsert(Driver object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("last_name", object.getLastName());
		parameters.put("first_name", object.getFirstName());
		parameters.put("age", object.getAge());

		return parameters;
	}

}
