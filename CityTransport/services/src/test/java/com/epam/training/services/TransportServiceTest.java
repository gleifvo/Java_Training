package com.epam.training.services;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.dataaccess.model.TransportType;

public class TransportServiceTest extends AbstractSpringTest {

	@Autowired
	private TransportService transportService;

	@Autowired
	private RouteService routeService;

	@Autowired
	private TransportTypeService transportTypeService;

	private static Transport transport;

	@Test
	public void InsertUpdateDeleteTest() {

		transport = new Transport();

		List<TransportType> types = transportTypeService.getAll();
		
		List<Route> routes = routeService.getAll();
		
		randomfilling(types, routes);

		transportService.addTransport(transport);

		randomfilling(types, routes);

		transportService.updateTransport(transport);

		transportService.deleteByRegistrationNumber(transport.getRegistrationNumber());
	}

	private void randomfilling(List<TransportType> types, List<Route> routes) {
		transport.setRegistrationNumber(
				RandomStringUtils.randomAlphanumeric(new Random().nextInt(40)));

		transport.setRouteId(routes.get(new Random().nextInt(routes.size())).getId());

		transport.setTypeId(types.get(new Random().nextInt(types.size())).getId());
	}
}
