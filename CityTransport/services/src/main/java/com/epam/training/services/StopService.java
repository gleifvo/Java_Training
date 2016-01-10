package com.epam.training.services;

import java.util.List;

import com.epam.training.dataaccess.model.Stop;

public interface StopService {

	List<Stop> getAll();

	void deleteByNumber(Long id);

	List<Stop> getAll(long first, long count, String field, String order);

	void update(Stop stop);

	void add(Stop stop);

	Integer getCountStops();

}
