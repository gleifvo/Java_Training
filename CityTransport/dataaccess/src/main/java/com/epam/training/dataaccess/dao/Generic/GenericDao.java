package com.epam.training.dataaccess.dao.Generic;

import java.util.List;

public interface GenericDao<T> {
	
	 List<T> getAll();
	 
	 List<T> getAll(long first, long count);
	
	 T getById(Long id);
	
	 void deleteById(Long id);
	
	 Long insert(T object);

	 void update(T object);
	 
}
