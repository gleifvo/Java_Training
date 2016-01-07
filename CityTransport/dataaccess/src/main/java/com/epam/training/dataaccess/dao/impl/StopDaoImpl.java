package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.StopDao;
import com.epam.training.dataaccess.dao.generic.GenericDaoImpl;
import com.epam.training.dataaccess.model.Stop;

@Repository
public class StopDaoImpl extends GenericDaoImpl<Stop>implements StopDao {

	public StopDaoImpl() {
		super();
		tableName = "stop";
	}

	@Override
	protected Map<String, Object> getParametersForInsert(Stop object) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", object.getName());

		return parameters;
	}

}
