package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.epam.training.webapp.page.home.HomePage;

public class PanelForLoggedUser extends Panel {

	public PanelForLoggedUser(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("Logout") {
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		
		Label label = new Label("Name-label");
		label.setDefaultModel(new Model<String>("Hello, Username"));
		add(label);
	}
}
