package com.epam.training.services;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeService {
	
	void insertOrUpdate(TransportType transportType);

	TransportType get(Long id);	
}
