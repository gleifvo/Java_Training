package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.Transport;

public interface TransportDao {
	
	Transport getById(Long id);

	void insert(Transport transport);

	void update(Transport transport);
	
	void delete(Long id);
}
