package com.epam.training.dataaccess.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.dataaccess.dao.GenericDaoInterface;

public class GenericDao<T> implements GenericDaoInterface<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	protected String tableName;

	@SuppressWarnings("unchecked")
	private Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	@Override
	public T getById(Long id) {

		return jdbcTemplate.queryForObject("SELECT * FROM " + tableName + " WHERE id = ?",
				new Object[] { id }, new BeanPropertyRowMapper<T>(classOfObjectClass));
	}

	@Override
	public List<T> getAll() {
		return jdbcTemplate.query("SELECT * FROM " + tableName,
				new BeanPropertyRowMapper<T>(classOfObjectClass));
	}

	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("DELETE FROM " + tableName + " WHERE id = ?", id);

	}
}
