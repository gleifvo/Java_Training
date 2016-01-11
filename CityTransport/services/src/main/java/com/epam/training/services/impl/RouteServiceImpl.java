package com.epam.training.services.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.dao.RouteToStopDao;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.RouteToStop;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private RouteToStopDao routeToStopDao;

	@Override
	public Route getRouteByNumber(Long id) {
		return routeDao.getById(id);
	}

	@Override
	public void deleteRouteByNumber(Long id) {
		routeDao.deleteById(id);

	}

	@Override
	public void addRoute(Route route) {
		route.setId(routeDao.insert(route));

	}

	@Override
	public void updateRoute(Route route) {
		routeDao.update(route);

	}

	@Override
	public List<Route> getAll() {
		return routeDao.getAll();
	}

	@Override
	public List<Route> getAll(long first, long count, String field, String order) {
		return routeDao.getAll(first, count, field, order);
	}

	@Override
	public List<Stop> getStops(Route route) {
		return routeDao.getStops(route);
	}

	@Override
	public Integer getCountRoutes() {
		return routeDao.getCount();
	}

	@Override
	public void addStop(Long routeId, Long stopId) {
		RouteToStop routeToStop = new RouteToStop(routeId, stopId);
		routeToStopDao.insert(routeToStop);
	}

	@Override
	public void deleteStop(Long routeId, Long stopId) {
		routeToStopDao.deleteEntry(stopId, routeId);
	}

	@Override
	public Map<Stop, Map<Integer, List<Integer>>> getSchedule(Route route) {

		int startWorkingTime = 6;

		int endWorkingTime = 22;

		Integer interval = route.getInterval();

		Map<Stop, Map<Integer, List<Integer>>> schedule = new LinkedHashMap<>();

		List<Stop> stops = getStops(route);

		int minutesPerHour = 60;

		Integer minutes = 0;

		Map<Integer, List<Integer>> timeMap = new LinkedHashMap<>();

		for (Stop stop : stops) {

			timeMap = new LinkedHashMap<>();

			int stopNumber = stops.indexOf(stop);

			minutes = interval * stopNumber;

			for (int hour = startWorkingTime; hour < endWorkingTime; hour++) {

				List<Integer> minutesList = new ArrayList<>();

				for (int min = minutes;; min += interval) {

					if (min / minutesPerHour != 0) {
						minutes = min % minutesPerHour;
						break;
					}

					minutesList.add(min);
				}
				timeMap.put(hour, minutesList);

			}

			schedule.put(stop, timeMap);
		}

		return schedule;
	}
}
