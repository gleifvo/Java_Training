package com.epam.training.services;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.dataaccess.model.TransportType;

public class TransportTypeServiceTest extends AbstractSpringTest {

	@Autowired
	TransportTypeService transportTypeService;

	@Test
	public void InsertUpdateDeleteTest() {

		TransportType transportType = new TransportType();

		randomfilling(transportType);
		
		transportTypeService.addTransportType(transportType);
		
		randomfilling(transportType);
		
		transportTypeService.updateTransportType(transportType);
		
		Assert.assertTrue(transportTypeService.getAll().contains(transportType));
		
		transportTypeService.deleteByType(transportType.getTransportType());
		
		Assert.assertFalse(transportTypeService.getAll().contains(transportType));
	}

	private void randomfilling(TransportType transportType) {
		transportType.setCapacity(new Random().nextInt(350));

		transportType.setMaxSpeed(new Random().nextInt(120));

		transportType
				.setTransportType(RandomStringUtils.randomAlphanumeric(new Random().nextInt(10)));
	}
}
