package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeService {
	
	
	void addTransportType(TransportType transportType);
	
	void updateTransportType(TransportType transportType);

	TransportType getByName(String typeName);	
	
	void delete(String type);
	
	List<TransportType> getAll();
}