package com.epam.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.dao.TransportTypeDao;
import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.services.TransportTypeService;

public class TransportTypeServiceImpl implements TransportTypeService {
	@Autowired
	private TransportTypeDao transportTypeDao;

	@Override
	public void insertOrUpdate(TransportType transportType) {
		if (transportTypeDao.getById(transportType.getId()) == null) {
			transportTypeDao.insert(transportType);
		} else {
			transportTypeDao.update(transportType);
		}
	}

	@Override
	public TransportType get(Long id) {
		return transportTypeDao.getById(id);
	}
}
