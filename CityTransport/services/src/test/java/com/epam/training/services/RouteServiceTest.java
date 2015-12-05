package com.epam.training.services;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.utils.AbstractSpringTest;

public class RouteServiceTest extends AbstractSpringTest {
	
	@Autowired
	private RouteService routeService;
	

	private static Route route = new Route();

	@Test
	public void InsertTest() {
		

		route.setId(2L);
		
		System.out.println(routeService.getStops(route));

		route.setInterval(new Random().nextInt(10));

		routeService.addRoute(route);
	}

	@Test
	public void UpdateTest() {

		route.setInterval(new Random().nextInt(100));

		routeService.updateRoute(route);
	}

	@Test
	public void getTest() {

		Route testRoute = routeService.getRouteByNumber(route.getId());

		Assert.assertEquals(route, testRoute);
	}

	@Test
	public void delTest() {
		routeService.deleteRouteByNumber(route.getId());
	}
}
