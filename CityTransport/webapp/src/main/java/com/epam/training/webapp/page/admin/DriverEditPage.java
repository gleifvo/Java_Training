package com.epam.training.webapp.page.admin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.services.DriverService;
import com.epam.training.services.TransportService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.renderer.TransportChoiceRenderer;
import com.googlecode.wicket.jquery.ui.form.palette.Palette;

@AuthorizeInstantiation(value = { "admin" })
public class DriverEditPage extends AbstractPage {

	private List<Transport> transportList = new ArrayList<Transport>();
	private List<Transport> selectedTransport = new ArrayList<Transport>();

	@Inject
	private DriverService driverService;

	@Inject
	private TransportService transportService;

	private Driver driver = new Driver();

	private boolean isNew;

	public DriverEditPage() {
		this(new Driver());
		isNew = true;
	}

	public DriverEditPage(Driver driver) {
		super();
		this.driver = driver;
		isNew = false;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<Driver> form = new Form<>("form", new CompoundPropertyModel<>(driver));
		add(form);

		TextField<String> firstNameField = new TextField<String>("firstName");
		firstNameField.setRequired(true);
		form.add(firstNameField);
		TextField<String> lastNameField = new TextField<String>("lastName");
		lastNameField.setRequired(true);
		form.add(lastNameField);
		TextField<String> ageField = new TextField<String>("age");
		ageField.setRequired(true);
		form.add(ageField);

		IChoiceRenderer<Transport> renderer = new TransportChoiceRenderer();

		selectedTransport = driverService.getDriverTransports(driver.getId());

		transportList = transportService.getAll();

		final Palette<Transport> palette = new Palette<Transport>("palette",
				new ListModel<Transport>(selectedTransport),
				new CollectionModel<Transport>(transportList), renderer, 10, false);

		form.add(palette);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (isNew) {
					driverService.add(driver);
				} else {
					driverService.update(driver);
				}

				transportList.removeAll(selectedTransport);

				for (Transport transport : transportList) {
					driverService.deleteTransport(transport.getId(), driver.getId());
				}

				for (Transport transport : selectedTransport) {
					driverService.addTransport(transport.getId(), driver.getId());
				}

				setResponsePage(new DriversPage());

			}
		});

	}
}
