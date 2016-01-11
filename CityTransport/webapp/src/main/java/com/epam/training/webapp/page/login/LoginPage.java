package com.epam.training.webapp.page.login;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import com.epam.training.webapp.app.CustomSession;
import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.page.user.UsersPage;

public class LoginPage extends AbstractPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));
		add(new FeedbackPanel("feedbackPanel"));
		Form<Void> form = new Form<Void>("login-form");

		final Model<String> loginModel = new Model(null);
		final Model<String> passModel = new Model(null);

		TextField<String> loginTf = new TextField<String>("login", loginModel);
		form.add(loginTf);

		TextField<String> passTf = new PasswordTextField("pass", passModel);
		form.add(passTf);

		add(form);

		form.add(new SubmitLink("submit") {
			@Override
			public void onSubmit() {
				super.onSubmit();

				try {
					boolean isSuccess = CustomSession.get().signIn(loginModel.getObject(),
							passModel.getObject());

					if (isSuccess) {
						setResponsePage(new UsersPage());
					} else {
						error("Incorrect password");
						setResponsePage(getPage());
					}

				} catch (RuntimeException e) {
					error(e.getMessage());
				}

			}
		});
	}
}
