package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.UserTypeDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.UserType;

@Repository
public class UserTypeDaoImpl extends GenericDaoImpl<UserType>implements UserTypeDao {

	public UserTypeDaoImpl() {
		super();
		tableName = "user_type";
	}

	@Override
	protected Map<String, Object> getParametersForInsert(UserType object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("type", object.getType());

		return parameters;
	}

	@Override
	public Long getIdByType(String type) {
		UserType transportType = jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + "  WHERE type = ?",
				new Object[] { type },
				new BeanPropertyRowMapper<UserType>(UserType.class));
		return transportType.getId();
	}
}
