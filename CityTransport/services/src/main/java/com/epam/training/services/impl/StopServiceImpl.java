package com.epam.training.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.StopDao;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.StopService;

@Service
public class StopServiceImpl implements StopService {

	@Autowired
	private StopDao stopDao;

	@Override
	public List<Stop> getAll() {
		return stopDao.getAll();
	}

	@Override
	public void deleteByNumber(Long id) {

		stopDao.deleteById(id);
	}

	@Override
	public void add(Stop stop) {
		stop.setId(stopDao.insert(stop));
	}

	@Override
	public void update(Stop stop) {
		stopDao.update(stop);

	}

	@Override
	public List<Stop> getAll(long first, long count, String field, String order) {
		return stopDao.getAll(first, count, field, order);
	}
	
	@Override
	public Integer getCountStops() {
		return stopDao.getCount();
	}

}
