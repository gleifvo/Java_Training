package com.epam.training.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.TransportDao;
import com.epam.training.dataaccess.dao.mapper.TransportMapper;
import com.epam.training.dataaccess.model.Transport;

@Repository
public class TransportDaoImpl implements TransportDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Transport getById(Long id) {
		return jdbcTemplate.queryForObject("select * from transport where id = ?",
				new Object[] { id }, new TransportMapper());
	}

	@Override
	public void insert(Transport transport) {
		jdbcTemplate.update(
				"INSERT INTO transport (registration_number,type_id) VALUES (?,?)",
				transport.getRegistration_number(), transport.getTypeId());

	}

	@Override
	public void update(Transport transport) {
		jdbcTemplate.update(
				"UPDATE transport SET registration_number = ?  type_id = ? WHERE  id = ?",
				transport.getRegistration_number(), transport.getTypeId(),
				transport.getId());
	}
	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM transport WHERE id = ?",
				id);		
	}
}
