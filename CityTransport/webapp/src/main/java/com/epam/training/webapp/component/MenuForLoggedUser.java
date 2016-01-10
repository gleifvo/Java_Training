package com.epam.training.webapp.component;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.admin.DriversPage;
import com.epam.training.webapp.page.admin.RoutesPage;
import com.epam.training.webapp.page.admin.StopsPage;
import com.epam.training.webapp.page.home.HomePage;

public class MenuForLoggedUser extends Panel {

	public MenuForLoggedUser(String id) {
		super(id);

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

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

		BookmarkablePageLink<Void> driversPage = new AdminPage("drivers-page",
				DriversPage.class);

		add(driversPage);

		BookmarkablePageLink<Void> routesPage = new AdminPage("routes-page",
				RoutesPage.class);

		add(routesPage);
		
		BookmarkablePageLink<Void> stopsPage = new AdminPage("stops-page",
				StopsPage.class);

		add(stopsPage);

	}

	@AuthorizeAction(roles = { "admin" }, action = "RENDER")

	private class AdminPage extends BookmarkablePageLink<Void> {

		public AdminPage(String id, Class pageClass) {
			super(id, pageClass);
		}

	}
}
