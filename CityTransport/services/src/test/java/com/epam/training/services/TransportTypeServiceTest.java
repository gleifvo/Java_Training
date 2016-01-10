package com.epam.training.services;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.utils.AbstractSpringTest;

public class TransportTypeServiceTest extends AbstractSpringTest {

	@Autowired
	TransportTypeService transportTypeService;

	@Test
	public void InsertUpdateDeleteTest() {

		TransportType transportType = new TransportType();

		randomfilling(transportType);

		transportTypeService.add(transportType);

		randomfilling(transportType);

		transportTypeService.update(transportType);

		Assert.assertTrue(transportTypeService.getAll().contains(transportType));

	}

	private void randomfilling(TransportType transportType) {
		transportType.setCapacity(new Random().nextInt(350));

		transportType.setMaxSpeed(new Random().nextInt(120));

		transportType.setTransportType(
				RandomStringUtils.randomAlphanumeric(new Random().nextInt(10)));
	}
}
