package com.epam.training.webapp.page.admin;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.services.DriverService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class DriverEditPage extends AbstractPage {

	@Inject
	private DriverService driverService;

	private Driver driver;

	public DriverEditPage() {
		this(new Driver());
	}

	public DriverEditPage(Driver driver) {
		super();
		this.driver = driver;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<Driver> form = new Form<>("form", new CompoundPropertyModel<>(driver));
		add(form);

		form.add(new TextField<String>("firstName"));
		form.add(new TextField<String>("lastName"));
		form.add(new TextField<String>("age"));

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				driverService.update(driver);

				setResponsePage(new DriversPage());

			}
		});

	}
}
