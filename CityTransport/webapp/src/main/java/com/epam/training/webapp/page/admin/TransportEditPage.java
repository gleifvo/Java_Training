package com.epam.training.webapp.page.admin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Transport;
import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.services.DriverService;
import com.epam.training.services.RouteService;
import com.epam.training.services.TransportService;
import com.epam.training.services.TransportTypeService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.renderer.DriverChoiceRenderer;
import com.googlecode.wicket.jquery.ui.form.palette.Palette;
import com.googlecode.wicket.kendo.ui.form.dropdown.DropDownList;

@AuthorizeInstantiation(value = { "admin" })
public class TransportEditPage extends AbstractPage {

	private List<Driver> driversList = new ArrayList<Driver>();
	private List<Driver> selectedDrivers = new ArrayList<Driver>();

	@Inject
	private TransportService transportService;

	@Inject
	private RouteService routeService;

	@Inject
	private TransportTypeService transportTypeService;

	@Inject
	private DriverService driverService;

	private Transport transport;

	private List<String> transportTypes = new ArrayList<String>();

	private List<Long> routes = new ArrayList<Long>();

	private boolean isNew;

	private Long selectedId;

	private String selectedType;

	public TransportEditPage() {
		isNew = true;
		getTypes();
		getRoutes();
		transport = new Transport();

	}

	public TransportEditPage(Transport transport) {
		this();
		this.transport = transport;
		isNew = false;

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		if (!isNew) {

			selectedDrivers = driverService
					.getDriversByRegNumber(transport.getRegistrationNumber());
		}

		Form<Transport> form = new Form<>("form", new CompoundPropertyModel<>(transport));
		add(form);

		TextField<String> textField = new TextField<String>("registrationNumber");
		textField.setRequired(true);
		form.add(textField);

		final DropDownChoice<Long> listRoutes = new DropDownChoice<Long>("selectRoute",
				new PropertyModel<Long>(this, "selectedId"), routes);
		setDefaultModelForRoute(listRoutes);

		form.add(listRoutes);

		final DropDownChoice<String> listTypes = new DropDownChoice<String>("selectType",
				new PropertyModel<String>(this, "selectedType"), transportTypes);
		setDefaultModelForType(listTypes);
		add(form);
		form.add(listTypes);

		IChoiceRenderer<Driver> renderer = new DriverChoiceRenderer();

		driversList = driverService.getAll();
		final Palette<Driver> palette = new Palette<Driver>("palette",
				new ListModel<Driver>(selectedDrivers),
				new CollectionModel<Driver>(driversList), renderer, 10, false);
		form.add(palette);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				transport.setTypeId(transportTypeService
						.getByName(listTypes.getModelObject()).getId());

				transport.setRouteId(listRoutes.getModelObject());

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

	private void setDefaultModelForType(final DropDownChoice<String> dropdown) {
		if (!isNew) {
			dropdown.setDefaultModelObject(
					transportService.getTypeById(transport.getTypeId()));
		}

		else {
			dropdown.setDefaultModelObject(
					transportTypeService.getByName((transportTypes.get(0))));
		}
	}

	private void setDefaultModelForRoute(final DropDownChoice<Long> dropdown) {

		if (!isNew) {
			dropdown.setDefaultModelObject(transport.getRouteId());
		}

		else {
			dropdown.setDefaultModelObject(routes.get(0));
		}
	}

	private void getTypes() {
		List<TransportType> allTypes = transportTypeService.getAll();
		for (TransportType transportType : allTypes) {
			transportTypes.add(transportType.getTransportType());
		}
	}

	private void getRoutes() {
		List<Route> allRoutes = routeService.getAll();
		for (Route route : allRoutes) {
			routes.add(route.getId());
		}
	}
}
