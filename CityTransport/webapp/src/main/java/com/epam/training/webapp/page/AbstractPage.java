package com.epam.training.webapp.page;

import java.util.Random;

import org.apache.wicket.markup.html.WebPage;

import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.MenuForLoggedUserPanel;
import com.epam.training.webapp.page.home.HomePage;

public class AbstractPage extends WebPage {

	@Override
	protected void onInitialize() {

		super.onInitialize();

		//add(new MenuForAnonymUser("menu-panel"));

		add(new MenuForLoggedUserPanel("menu-panel"));

	}

}
