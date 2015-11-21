package com.epam.training.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.services.RouteService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext(
				"spring-context.xml");

		RouteService routeService = aContext.getBean(RouteService.class);
		
		routeService.delete(3L);
	}
}
