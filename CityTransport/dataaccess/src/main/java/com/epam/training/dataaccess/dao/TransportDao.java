package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.Transport;

public interface TransportDao {
	
	Transport getByRegistryNumber(String id);
	
	List<Transport> getByRouteId(Long id);

	Long insert(Transport transport);

	void update(Transport transport);
	
	void deleteByRegistrationNumber(String regNumber);
	
	List<Transport> getByTypeId(Long id);
}
