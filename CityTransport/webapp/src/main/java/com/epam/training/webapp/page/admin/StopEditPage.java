package com.epam.training.webapp.page.admin;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.StopService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class StopEditPage extends AbstractPage {

	@Inject
	private StopService stopService;

	private Stop stop = new Stop();

	private boolean isNew;

	public StopEditPage() {
		this(new Stop());
		isNew = true;
	}

	public StopEditPage(Stop stop) {
		super();
		this.stop = stop;
		isNew = false;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<Stop> form = new Form<>("form", new CompoundPropertyModel<>(stop));
		add(form);

		form.add(new TextField<String>("name"));

		IChoiceRenderer<Stop> renderer = new ChoiceRenderer<Stop>("name", "id");

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (isNew) {
					stopService.add(stop);
				} else {
					stopService.update(stop);
				}

				setResponsePage(new StopsPage());

			}
		});

	}
}
