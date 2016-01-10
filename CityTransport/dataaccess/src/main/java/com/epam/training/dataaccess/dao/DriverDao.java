package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.dao.generic.GenericDao;
import com.epam.training.dataaccess.model.Driver;

public interface DriverDao extends GenericDao<Driver> {

	List<Driver> getDriversByRegNumber(String number);

	Integer getCount();
}
