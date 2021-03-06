package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.UserDao;
import com.epam.training.dataaccess.dao.generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User>implements UserDao {

	public UserDaoImpl() {
		super();
		tableName = "user_info";
	}

	@Override
	protected Map<String, Object> getParametersForInsert(User object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("login", object.getLogin());
		parameters.put("password", object.getPassword());
		parameters.put("user_type_id", object.getUserTypeId());

		return parameters;
	}

	@Override
	public User getByLogin(String login) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM " + tableName + "  where login = ?",
				new Object[] { login }, new BeanPropertyRowMapper<User>(User.class));

	}

}
