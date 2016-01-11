package com.epam.training.webapp.renderer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;

import com.epam.training.dataaccess.model.Transport;
import com.epam.training.services.TransportService;

public class TransportRenderer extends Transport {

	@Inject
	private TransportService transportService;

	public static List<TransportRenderer> convert(List<Transport> list) {

		List<TransportRenderer> newList = new ArrayList<TransportRenderer>();
		for (Transport transport : list) {
			newList.add(new TransportRenderer(transport));
		}
		
		return newList;
		
		
	}

	public TransportRenderer() {
		super();
		Injector.get().inject(this);
	}

	public TransportRenderer(Transport modelObject) {
		this();
		this.setId(modelObject.getId());
		this.setRegistrationNumber(modelObject.getRegistrationNumber());
		this.setRouteId(modelObject.getRouteId());
		this.setTypeId(modelObject.getTypeId());
	}

	public String getType() {
		return transportService.getTypeById(getTypeId());
	}

}
