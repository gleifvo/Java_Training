package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeDao {

	TransportType getById(Long id);

	void insert(TransportType transportType);

	void update(TransportType transportType);
	
	void delete(Long id);
}
