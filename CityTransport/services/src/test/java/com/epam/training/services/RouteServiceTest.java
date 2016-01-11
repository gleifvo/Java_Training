package com.epam.training.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.utils.AbstractSpringTest;

public class RouteServiceTest extends AbstractSpringTest {

	@Autowired
	private RouteService routeService;

	private static Route route = new Route();

	@Test
	public void sheduleTest() {

		route.setId(15L);
		route.setInterval(9);
		Map<Stop, Map<Integer, List<Integer>>> schedule = routeService.getSchedule(route);

		for (Entry<Stop, Map<Integer, List<Integer>>> entry : schedule.entrySet()) {
			System.out.println(entry.getKey().toString());
			for (Entry<Integer, List<Integer>> timeEntry : entry.getValue().entrySet()) {
				System.out.println("Hour: " + timeEntry.getKey());
				for (Integer minute : timeEntry.getValue()) {
					System.out.print(minute + " ");
				}
				System.out.println();
			}
		}
	}
}
