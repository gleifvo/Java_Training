package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;

import com.epam.training.webapp.page.home.HomePage;

public class MenuForLoggedUserPanel extends MenuForAnonymUser {

	public MenuForLoggedUserPanel(String id) {
		super(id);
		add(new Link<Void>("Logout") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}
}
