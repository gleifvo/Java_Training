package com.epam.training.dataaccess.dao;

import java.util.List;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.RouteToUser;

public interface RouteToUserDao {

	void insert(final RouteToUser routeRoUser);

	void deleteEntry(Long routeId, Long userId);

	List<Route> getUserFavorite(Long id);

}
