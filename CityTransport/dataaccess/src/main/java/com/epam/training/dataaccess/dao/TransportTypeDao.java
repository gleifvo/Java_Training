package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.dao.Generic.GenericDao;
import com.epam.training.dataaccess.model.TransportType;

public interface TransportTypeDao extends GenericDao<TransportType> {

	TransportType getByTypeName(String type);

	Long getIdByType(String type);
}
