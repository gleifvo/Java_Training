package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeDao extends GenericDaoInterface<TransportType>{

	TransportType getByTypeName(String type);

	Long insert(TransportType transportType);

	void update(TransportType transportType);
	
	void deleteByRegNumber(String type);
	
	Long getIdByType(String type);
}
