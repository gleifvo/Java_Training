package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.home.HomePage;
import com.epam.training.webapp.page.user.UserRegisterPage;

public class PanelForAnonymUser extends Panel {
	
	public PanelForAnonymUser(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("Sign-in") {

			@Override
			public void onClick() {
				setResponsePage(UserRegisterPage.class);
			}
		});
		
		add(new Link<Void>("Sign-up") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}
}
