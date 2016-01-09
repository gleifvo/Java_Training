package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.Transport;

public interface DriverService {

	Driver getById(Long id);
	
	void add(Driver driver);

	void update(Driver driver);

	List<Driver> getAll();

	List<Driver> getAll(long first, long count);

	List<Driver> getAll(long first, long count, String field, String order);
	
	List<Driver> getDriversByRegNumber(String number);
	
	List<Transport> getDriverTransports(Long id);

	void addTransport(Long transportId, Long driverId);

	void deleteTransport(Long transportId, Long driverId);

	void deleteDriver(Long id);

}
