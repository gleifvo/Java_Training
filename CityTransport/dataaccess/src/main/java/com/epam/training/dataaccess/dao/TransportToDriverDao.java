package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.Transport;
import com.epam.training.dataaccess.model.TransportToDriver;

public interface TransportToDriverDao {

	void insert(final TransportToDriver transportToDriver);

	public List<Transport> getDriverTransports(Long id);
}
