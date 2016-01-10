package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeService {
	
	void add(TransportType transportType);
	
	void update(TransportType transportType);

	TransportType getByName(String typeName);	
	
	List<TransportType> getAll();

	List<TransportType> getAll(long first, long count, String field, String order);

	Integer getCountTypes();

	void delete(Long id);
}