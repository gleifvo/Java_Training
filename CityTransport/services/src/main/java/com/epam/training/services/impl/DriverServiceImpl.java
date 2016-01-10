package com.epam.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.DriverDao;
import com.epam.training.dataaccess.dao.TransportToDriverDao;
import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.dataaccess.model.TransportToDriver;
import com.epam.training.services.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private TransportToDriverDao transportToDriverDao;

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

	@Override
	public List<Transport> getDriverTransports(Long id) {
		return transportToDriverDao.getDriverTransports(id);
	}

	@Override
	public void addTransport(Long transportId, Long driverId) {
		TransportToDriver transportToDriver = new TransportToDriver(transportId,
				driverId);
		transportToDriverDao.insert(transportToDriver);
	}

	@Override
	public void deleteTransport(Long transportId, Long driverId) {
		transportToDriverDao.deleteEntry(transportId, driverId);
	}

	@Override
	public void deleteDriver(Long id) {
		driverDao.deleteById(id);
	}

    @Override
    public Integer getCountDrivers() {
        return driverDao.getCount();
    }

}
