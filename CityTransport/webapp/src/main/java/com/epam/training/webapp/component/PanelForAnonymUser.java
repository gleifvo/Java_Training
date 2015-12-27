package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.home.HomePage;

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
				setResponsePage(HomePage.class);
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
