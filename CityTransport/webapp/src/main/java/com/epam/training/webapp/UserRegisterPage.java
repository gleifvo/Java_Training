package com.epam.training.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.services.RouteService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext(
				"spring-context.xml");

		RouteService routeService = aContext.getBean(RouteService.class);

		Route route = new Route();
		route = routeService.get(8L);
		
		route.setInterval(321);
		
		routeService.insertOrUpdate(route);

	}
}
