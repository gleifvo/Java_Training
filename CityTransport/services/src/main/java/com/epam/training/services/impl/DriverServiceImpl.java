package com.epam.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.DriverDao;
import com.epam.training.dataaccess.model.Driver;
import com.epam.training.services.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;

	@Override
	public void add(Driver driver) {
		driver.setId(driverDao.insert(driver));

	}

	@Override
	public void update(Driver driver) {
		driverDao.update(driver);

	}

	@Override
	public List<Driver> getAll() {
		return driverDao.getAll();
	}

	@Override
	public List<Driver> getAll(long first, long count) {
		return driverDao.getAll(first, count);
	}

	@Override
	public List<Driver> getAll(long first, long count, String field, String order) {
		return driverDao.getAll(first, count, field, order);
	}

	@Override
	public List<Driver> getDriversByRegNumber(String number) {
		return driverDao.getDriversByRegNumber(number);
	}

	@Override
	public Driver getById(Long id) {
		return driverDao.getById(id);
	}

}
