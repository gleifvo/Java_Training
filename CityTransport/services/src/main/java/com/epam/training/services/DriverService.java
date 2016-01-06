package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Driver;

public interface DriverService {

	void add(Driver driver);

	void update(Driver driver);

	List<Driver> getAll();

	List<Driver> getAll(long first, long count);

	List<Driver> getAll(long first, long count, String field, String order);
	
	List<Driver> getDriversByRegNumber(String number);

}
