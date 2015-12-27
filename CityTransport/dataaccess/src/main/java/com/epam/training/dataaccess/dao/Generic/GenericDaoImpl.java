package com.epam.training.dataaccess.dao.Generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

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

	protected abstract Map<String, Object> getParametersForInsert(T entity);

	@Override
	public Long insert(T entity) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");
		return jdbcInsert
				.executeAndReturnKey(
						new MapSqlParameterSource(getParametersForInsert(entity)))
				.longValue();
	}

}
