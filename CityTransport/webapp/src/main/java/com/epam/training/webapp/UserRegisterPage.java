package com.epam.training.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.dataaccess.dao.RouteDao;
import com.epam.training.dataaccess.model.Route;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext(
				"spring-context.xml");

		RouteDao routeService = aContext.getBean(RouteDao.class);

		Route route = new Route();
		route.setInterval(150);
		
		
		System.out.println(routeService.insert(route));

	}
}
