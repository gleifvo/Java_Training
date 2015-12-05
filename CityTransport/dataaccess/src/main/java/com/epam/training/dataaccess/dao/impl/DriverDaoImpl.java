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
	public Long insert(final Driver driver) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName
								+ "  (last_name,first_name,age) VALUES (?,?,?)",
						new String[] { "id" });
				ps.setString(1, driver.getLastName());
				ps.setString(2, driver.getFirstName());
				ps.setInt(3, driver.getAge());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(Driver driver) {
		jdbcTemplate.update(
				"UPDATE " + tableName
						+ "  SET last_name = ?,first_name = ?,age = ? WHERE  id = ?",
				driver.getFirstName(), driver.getFirstName(), driver.getAge(),
				driver.getId());
	}

	@Override
	public List<Driver> getDriversByRegNumber(String number) {
		return jdbcTemplate.query("SELECT * FROM driver D " + "WHERE  D.id in "
				+ "( SELECT t2d.driver_id FROM transport_2driver t2d"
				+ " WHERE  t2d.transport_id in " + "( SELECT T.id FROM transport T"
				+ " WHERE T.registration_number = ?))", new Object[] { number },
				new BeanPropertyRowMapper<Driver>(Driver.class));
	}

}
