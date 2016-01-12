package com.epam.training.webapp.page.user;

import javax.inject.Inject;

import com.epam.training.services.UserService;
import com.epam.training.webapp.app.CustomSession;

public class FavoriteRoutesPage extends RoutesPageForLoggedUser {

	@Inject
	private UserService userService;

	private Long currentUserid;

	public FavoriteRoutesPage() {
		super();
		currentUserid = CustomSession.get().getCurrentUserid();
		allRoutes = userService.getUserRoutes(currentUserid);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

	}
}
