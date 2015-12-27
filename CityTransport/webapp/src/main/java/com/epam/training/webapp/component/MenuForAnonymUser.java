package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.home.HomePage;

public class MenuForAnonymUser extends Panel {
	public MenuForAnonymUser(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("Sign-in") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}
}
