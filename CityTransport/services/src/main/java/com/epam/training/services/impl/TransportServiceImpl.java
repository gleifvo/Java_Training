package com.epam.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.TransportDao;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.services.TransportService;

@Service
public class TransportServiceImpl implements TransportService {

	@Autowired
	TransportDao transportDao;

	@Override
	public void insertOrUpdate(Transport transport) {
		if (transportDao.getById(transport.getId()) == null) {
			transportDao.insert(transport);
		} else {
			transportDao.update(transport);
		}
	}

	@Override
	public Transport get(Long id) {
		return transportDao.getById(id);
	}
}
