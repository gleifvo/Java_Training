package com.epam.training.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.dataaccess.model.Transport;

public class TransportMapper implements RowMapper<Transport>{

	@Override
	public Transport mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transport transport = new Transport();
		
		transport.setRegistration_number(rs.getString("registration_nmber"));
		
		transport.setTypeId(rs.getLong("type_id"));
		
		return transport;
	}

}
