package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeDao {

	TransportType getByTypeName(String type);

	Long insert(TransportType transportType);

	void update(TransportType transportType);
	
	void delete(String type);
	
	Long getIdByType(String type);
	
	List<TransportType> getAll();
}
