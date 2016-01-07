package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.dao.generic.GenericDao;
import com.epam.training.dataaccess.model.UserType;

public interface UserTypeDao extends GenericDao<UserType> {

	Long getIdByType(String type);	
}
