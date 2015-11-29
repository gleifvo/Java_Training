package com.epam.training.dataaccess.dao;

import java.util.List;

public interface GenericDaoInterface<T> {
	
	public List<T> getAll();
	
	public T getById(Long id);
	
	void deleteById(Long id);
}
