package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.home.HomePage;
import com.epam.training.webapp.page.user.RoutesPageForAnonymUser;
import com.epam.training.webapp.page.user.RoutesPageForLoggedUser;

public class MenuForAnonymUser extends Panel {

	public MenuForAnonymUser(String id) {
		super(id);

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("btn-home") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});

		add(new Link<Void>("btn-shedule") {

			@Override
			public void onClick() {
				setResponsePage(RoutesPageForAnonymUser.class);
			}
		});
	}

}
