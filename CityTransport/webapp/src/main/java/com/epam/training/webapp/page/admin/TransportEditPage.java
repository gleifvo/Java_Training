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
import com.epam.training.services.TransportTypeService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.renderer.DriverChoiceRenderer;
import com.googlecode.wicket.jquery.ui.form.palette.Palette;

@AuthorizeInstantiation(value = { "admin" })
public class TransportEditPage extends AbstractPage {

	private List<Driver> driversList = new ArrayList<Driver>();
	private List<Driver> selectedDrivers = new ArrayList<Driver>();

	@Inject
	private TransportService transportService;

	@Inject
	private TransportTypeService transportTypeService;

	@Inject
	private DriverService driverService;

	private Transport transport = new Transport();

	private boolean isNew;

	public TransportEditPage() {
		this(new Transport());
		isNew = true;
	}

	public TransportEditPage(Transport transport) {
		super();
		this.transport = transport;
		isNew = false;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<Transport> form = new Form<>("form", new CompoundPropertyModel<>(transport));
		add(form);

		form.add(new TextField<String>("registrationNumber"));
		form.add(new TextField<String>("typeId"));
		form.add(new TextField<String>("routeId"));

		IChoiceRenderer<Driver> renderer = new DriverChoiceRenderer();

		selectedDrivers = driverService
				.getDriversByRegNumber(transport.getRegistrationNumber());

		driversList = driverService.getAll();

		final Palette<Driver> palette = new Palette<Driver>("palette",
				new ListModel<Driver>(selectedDrivers),
				new CollectionModel<Driver>(driversList), renderer, 10, false);

		form.add(palette);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (isNew) {
					transportService.addTransport(transport);
				} else {
					transportService.updateTransport(transport);
				}

				driversList.removeAll(selectedDrivers);

				for (Driver driver : driversList) {

					driverService.deleteTransport(transport.getId(), driver.getId());
				}

				for (Driver driver : selectedDrivers) {
					driverService.addTransport(transport.getId(), driver.getId());
				}

				setResponsePage(new TransportPage());

			}
		});

	}
}
