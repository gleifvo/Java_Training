package com.epam.training.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.TransportTypeDao;
import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.services.TransportTypeService;

@Service
public class TransportTypeServiceImpl implements TransportTypeService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TransportTypeServiceImpl.class);

	@Autowired
	private TransportTypeDao transportTypeDao;

	@Override
	public void addTransportType(TransportType transportType) {
		transportType.setId(transportTypeDao.insert(transportType));
		LOGGER.info(new SimpleDateFormat().format(new Date().getTime()) + " "
				+ transportType.toString() + " added");
	}

	@Override
	public void updateTransportType(TransportType transportType) {
		transportTypeDao.update(transportType);
		LOGGER.info(new SimpleDateFormat().format(new Date().getTime()) + " "
				+ transportType.toString() + " updated");
	}

	@Override
	public TransportType getByName(String typeName) {
		return transportTypeDao.getByTypeName(typeName);
	}

	@Override
	public List<TransportType> getAll() {
		return transportTypeDao.getAll();
	}
}
