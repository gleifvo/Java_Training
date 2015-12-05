package com.epam.training.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.UserTypeDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.UserType;

@Repository
public class UserTypeDaoImpl extends GenericDaoImpl<UserType>
		implements UserTypeDao {

	public UserTypeDaoImpl() {
		super();
		tableName = "user_type";
	}

	@Override
	public Long insert(final UserType userType) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName + " (type) VALUES (?)",
						new String[] { "id" });
				ps.setString(1, userType.getType());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(UserType userType) {
		jdbcTemplate.update("UPDATE " + tableName + "  SET type = ? WHERE  id = ?",
				userType.getType(), userType.getId());
	}
}
