package com.epam.training.webapp.page.user;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "user", "admin" })
public class UsersPage extends AbstractPage {
	@Override
	protected void onInitialize() {

		super.onInitialize();
		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
	}
}
