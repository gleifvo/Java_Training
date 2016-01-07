package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.dao.generic.GenericDao;
import com.epam.training.dataaccess.model.User;

public interface UserDao extends GenericDao<User> {
	
	public User getByLogin(String login);

}
