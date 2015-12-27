package com.epam.training.dataaccess.dao.Generic;

import java.util.List;

public interface GenericDao<T> {
	
	 List<T> getAll();
	
	 T getById(Long id);
	
	 void deleteById(Long id);
	
	 Long insert(T object);

	 void update(T object);
	 
}
