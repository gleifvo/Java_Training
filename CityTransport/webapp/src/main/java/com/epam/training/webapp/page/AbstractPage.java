package com.epam.training.webapp.page;

import org.apache.wicket.markup.html.WebPage;

import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForAnonymUser;

public class AbstractPage extends WebPage {

	@Override
	protected void onInitialize() {

		super.onInitialize();
		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));



		
		
	

	}

}
