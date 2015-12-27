package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.dao.Generic.GenericDao;
import com.epam.training.dataaccess.model.Transport;

public interface TransportDao extends GenericDao<Transport> {

	Transport getByRegistryNumber(String number);

	List<Transport> getByRouteId(Long id);

	void deleteByRegistrationNumber(String regNumber);

	List<Transport> getByTypeId(Long id);
}
