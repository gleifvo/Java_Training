package com.epam.training.dataaccess.dao.Generic;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.epam.training.dataaccess.model.AbstractObject;

public abstract class GenericDaoImpl<T extends AbstractObject> implements GenericDao<T> {

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
	public List<T> getAll(long first, long count) {
		return jdbcTemplate
				.query(String.format("SELECT * FROM" + tableName + "LIMIT %s OFFSET %s ",
						count, first), new BeanPropertyRowMapper<T>(classOfObjectClass));
	}

	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("DELETE FROM " + tableName + " WHERE id = ?", id);

	}

	protected abstract Map<String, Object> getParametersForInsert(T entity);

	@Override
	public Long insert(T object) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");
		return jdbcInsert
				.executeAndReturnKey(
						new MapSqlParameterSource(getParametersForInsert(object)))
				.longValue();
	}

	@Override
	public void update(T object) {
		StringBuilder updatingParameters = new StringBuilder();

		Map<String, Object> parametersForInsert = getParametersForInsert(object);
		Iterator<Map.Entry<String, Object>> iterator = parametersForInsert.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> parameter = iterator.next();
			if (parameter.getValue() != null) {
				updatingParameters.append(String.format("%s=?, ", parameter.getKey()));
			} else {
				iterator.remove();
				
			}
		}
		try {
			updatingParameters.deleteCharAt(updatingParameters.lastIndexOf(","));
		} catch (StringIndexOutOfBoundsException e) {
			return;
		}
		
		jdbcTemplate.update(
				String.format("UPDATE %s SET %s WHERE id = %s", tableName,
						updatingParameters, object.getId()),
				parametersForInsert.values().toArray());

	}

}
