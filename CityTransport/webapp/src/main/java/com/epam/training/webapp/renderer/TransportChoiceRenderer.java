package com.epam.training.webapp.renderer;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.form.ChoiceRenderer;

import com.epam.training.dataaccess.model.Transport;
import com.epam.training.services.TransportService;

public class TransportChoiceRenderer extends ChoiceRenderer<Transport> {

	public TransportChoiceRenderer() {
		super();
		Injector.get().inject(this);

	}

	@Inject
	private TransportService transportService;

	@Override
	public Object getDisplayValue(Transport object) {
		return String.format("%s, %s, %s", object.getRegistrationNumber(),
				transportService.getTypeById(object.getTypeId()), object.getRouteId());

	}

	@Override
	public String getIdValue(Transport object, int index) {
		return String.valueOf(object.getId());
	}
}
