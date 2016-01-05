package com.epam.training.webapp.page.home;

import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;

public class HomePage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));
	
	};
}
