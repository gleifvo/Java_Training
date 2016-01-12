package com.epam.training.webapp.page.user;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.epam.training.dataaccess.model.User;
import com.epam.training.services.UserService;
import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.page.home.HomePage;
import com.epam.training.webapp.page.login.LoginPage;

public class UserRegisterPage extends AbstractPage {

	@Inject
	private UserService userService;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));
		add(new FeedbackPanel("feedbackPanel"));

		final User newUser = new User();

		Form<User> form = new Form<>("form");
		add(form);

		form.add(new TextField<String>("login",
				new PropertyModel<String>(newUser, "login")));

		form.add(new PasswordTextField("password",
				new PropertyModel<String>(newUser, "password")));

		final TextField<String> confirmPasswordField = new PasswordTextField(
				"confirm-password", new Model<String>());
		form.add(confirmPasswordField);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (newUser.getPassword()
						.equals(confirmPasswordField.getDefaultModelObject())) {
					userService.registrationUser(newUser);
					setResponsePage(new LoginPage());
				} else {
					info(getString("passEror"));
				}
			}
		});

	}
}
