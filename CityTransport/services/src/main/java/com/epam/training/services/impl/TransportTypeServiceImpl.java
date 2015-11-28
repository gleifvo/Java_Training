package com.epam.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.TransportTypeDao;
import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.services.TransportTypeService;

@Service
public class TransportTypeServiceImpl implements TransportTypeService {
	@Autowired
	private TransportTypeDao transportTypeDao;

	@Override
	public void addTransportType(TransportType transportType) {
		transportType.setId(transportTypeDao.insert(transportType));
	}

	@Override
	public void updateTransportType(TransportType transportType) {
		transportTypeDao.update(transportType);
	}

	@Override
	public TransportType getByName(String typeName) {
		return transportTypeDao.getByTypeName(typeName);
	}

	@Override
	public void delete(String type) {
		transportTypeDao.delete(type);
	}

	@Override
	public List<TransportType> getAll() {
		return transportTypeDao.getAll();
	}
}
