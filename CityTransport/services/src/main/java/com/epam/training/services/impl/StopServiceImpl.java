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

}
