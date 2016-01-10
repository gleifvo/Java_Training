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
	public void add(TransportType transportType) {
		transportType.setId(transportTypeDao.insert(transportType));
	}

	@Override
	public void update(TransportType transportType) {
		transportTypeDao.update(transportType);
	}

	@Override
	public TransportType getByName(String typeName) {
		return transportTypeDao.getByTypeName(typeName);
	}

	@Override
	public List<TransportType> getAll() {
		return transportTypeDao.getAll();
	}

	@Override
	public List<TransportType> getAll(long first, long count, String field,
			String order) {
		return transportTypeDao.getAll(first, count, field, order);
	}

	@Override
	public Integer getCountTypes() {
		return transportTypeDao.getCount();
	}

	@Override
	public void delete(Long id) {
		transportTypeDao.deleteById(id);
	}

}
