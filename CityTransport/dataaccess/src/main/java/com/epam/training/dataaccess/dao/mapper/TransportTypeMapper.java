package com.epam.training.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.dataaccess.model.TransportType;

public class TransportTypeMapper implements RowMapper<TransportType> {

	@Override
	public TransportType mapRow(ResultSet rs, int rowNum) throws SQLException {

		TransportType transportType = new TransportType();

		transportType.setCapacity(rs.getInt("capacity"));

		transportType.setMaxSpeed(rs.getInt("max_speed"));

		transportType.setType(rs.getString("type"));

		return transportType;
	}

}
