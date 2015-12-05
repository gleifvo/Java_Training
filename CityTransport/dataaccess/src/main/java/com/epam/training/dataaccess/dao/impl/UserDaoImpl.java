package com.epam.training.dataaccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.UserDao;
import com.epam.training.dataaccess.dao.Generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User>implements UserDao{

	public UserDaoImpl() {
		super();
		tableName = "user";
	}

	@Override
	public Long insert(final User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO " + tableName
								+ "  (login,password,user_type_id) VALUES (?,?,?)",
						new String[] { "id" });
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ps.setLong(3, user.getUserTypeId());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update(
				"UPDATE " + tableName
						+ "  SET login = ?,password = ?,user_type_id = ? WHERE  id = ?",
				user.getLogin(), user.getPassword(), user.getUserTypeId(), user.getId());
	}

}
