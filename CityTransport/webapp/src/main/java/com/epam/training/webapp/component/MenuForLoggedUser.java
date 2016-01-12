package com.epam.training.webapp.component;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.epam.training.webapp.page.admin.DriversPage;
import com.epam.training.webapp.page.admin.RoutesPage;
import com.epam.training.webapp.page.admin.StopsPage;
import com.epam.training.webapp.page.admin.TransportPage;
import com.epam.training.webapp.page.admin.TransportTypePage;
import com.epam.training.webapp.page.home.HomePage;
import com.epam.training.webapp.page.user.FavoriteRoutesPage;
import com.epam.training.webapp.page.user.RoutesPageForLoggedUser;

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
				setResponsePage(RoutesPageForLoggedUser.class);
			}
		});

		add(new Link<Void>("Liked") {

			@Override
			public void onClick() {
				setResponsePage(FavoriteRoutesPage.class);
			}
		});

		add(new AdminPage("drivers-page", DriversPage.class));

		add(new AdminPage("routes-page", RoutesPage.class));

		add(new AdminPage("stops-page", StopsPage.class));

		add(new AdminPage("transport-page", TransportPage.class));

		add(new AdminPage("transport-type-page", TransportTypePage.class));

	}

	@AuthorizeAction(roles = { "admin" }, action = "RENDER")

	private class AdminPage extends BookmarkablePageLink<Void> {

		public AdminPage(String id, Class pageClass) {
			super(id, pageClass);
		}

	}
}
