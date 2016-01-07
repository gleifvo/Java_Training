package com.epam.training.webapp.app;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import com.epam.training.dataaccess.model.User;
import com.epam.training.services.UserService;

public class CustomSession extends AuthenticatedWebSession {

	@Inject
	private UserService userService;

	private User user;

	private Roles roles;

	public CustomSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	public static CustomSession get() {
		return (CustomSession) Session.get();
	}

	@Override
	protected boolean authenticate(String username, String password) {

		user = null;
		
		roles = null;
		
		user = new User(username, password);
		
		return userService.authenticate(user);
	}

	@Override
	public void signOut() {
		super.signOut();
		user = null;
		roles = null;
	}

	@Override
	public Roles getRoles() {
		if (user.getUserTypeId() == null) {
			return null;
		}
		if (roles == null) {
			roles = new Roles();
			roles.add(userService.getRole(user.getUserTypeId()));
		}
		return roles;
	}

	public Long getCurrentUserid() {
		return user.getId();
	}

	public String getCurrentUserLogin() {
		return user.getLogin();
	}

}
