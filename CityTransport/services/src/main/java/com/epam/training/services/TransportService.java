package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Transport;

public interface TransportService {

	void addTransport(Transport transport);
	
	void updateTransport(Transport transport);

	Transport getByRegistryNumber(String number);
	
	List<Transport> getAllByRoutesNumber(Long number);
	
	List<Transport> getAllByType(String type);
	
	List<Transport> getAll();
	
	void deleteByRegistrationNumber(String regNumber);
	
	String getTypeById(Long id);

	List<Transport> getAll(long first, long count, String field, String order);

	Integer getCountTransport();

}
