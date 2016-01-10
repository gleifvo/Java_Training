package com.epam.training.webapp.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.User;

public class DriverChoiceRenderer extends ChoiceRenderer<Driver> {

	@Override
	public Object getDisplayValue(Driver object) {
		return object.getFirstName() + " " + object.getLastName();
	}

	@Override
	public String getIdValue(Driver object, int index) {
		return String.valueOf(object.getId());
	}
}
