package com.epam.training.dataaccess.dao.generic;

import java.util.List;

public interface GenericDao<T> {

	List<T> getAll();

	List<T> getAll(long first, long count);

	List<T> getAll(long first, long count, String field, String order);

	T getById(Long id);

	void deleteById(Long id);

	Long insert(T object);

	void update(T object);

	Integer getCount();

}
