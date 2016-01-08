package com.epam.training.webapp.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.epam.training.webapp.app.CustomSession;
import com.epam.training.webapp.page.login.LoginPage;

public class PanelForLoggedUser extends Panel {

	public PanelForLoggedUser(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new LanguageSelectionComponent("lang-select"));
		add(new Link<Void>("Logout") {
			@Override
			public void onClick() {
                CustomSession.get().signOut();
                setResponsePage(LoginPage.class);
			}
		});
		
		Label label = new Label("Name-label");
		String currentUserLogin = CustomSession.get().getCurrentUserLogin();
		label.setDefaultModel(new Model<String>(getString("hello")+ currentUserLogin));
		add(label);
	}
}
