package com.epam.training.dataaccess.dao.Generic;

import java.util.List;

public interface GenericDao<T> {
	
	public List<T> getAll();
	
	public T getById(Long id);
	
	public void deleteById(Long id);
	
	public Long insert(T object);

	public void update(T object);
}
