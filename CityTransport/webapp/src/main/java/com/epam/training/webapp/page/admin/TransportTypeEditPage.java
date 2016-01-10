package com.epam.training.webapp.page.admin;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.epam.training.dataaccess.model.TransportType;
import com.epam.training.services.TransportTypeService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class TransportTypeEditPage extends AbstractPage {

	@Inject
	private TransportTypeService transportTypeService;

	private TransportType transportType = new TransportType();

	private boolean isNew;

	public TransportTypeEditPage() {
		this(new TransportType());
		isNew = true;
	}

	public TransportTypeEditPage(TransportType transportType) {
		super();
		this.transportType = transportType;
		isNew = false;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<TransportType> form = new Form<>("form",
				new CompoundPropertyModel<>(transportType));
		add(form);

		form.add(new TextField<String>("transportType"));
		form.add(new TextField<String>("capacity"));
		form.add(new TextField<String>("maxSpeed"));

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (isNew) {
					transportTypeService.add(transportType);
				} else {
					transportTypeService.update(transportType);
				}

				setResponsePage(new TransportTypePage());

			}
		});

	}
}
