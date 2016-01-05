package com.epam.training.webapp.page.user;

import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

public class UsersPage extends AbstractPage {
	@Override
	protected void onInitialize() {
		
		super.onInitialize();
		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));

	}
}
