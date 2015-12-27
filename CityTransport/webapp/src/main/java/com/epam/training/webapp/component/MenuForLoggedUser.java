package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.home.HomePage;

public class MenuForLoggedUser extends Panel {

	public MenuForLoggedUser(String id) {
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
				setResponsePage(HomePage.class);
			}
		});
		
		add(new Link<Void>("Liked") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
	}

}
