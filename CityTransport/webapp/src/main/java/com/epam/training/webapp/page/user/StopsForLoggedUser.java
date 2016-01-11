package com.epam.training.webapp.page.user;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;

public class StopsForLoggedUser extends StopsForAnonymUser {

	@Override
	protected void onInitialize() {
		super.onInitialize();

		this.addOrReplace(new PanelForLoggedUser("menu-panel"));
		this.addOrReplace(new MenuForLoggedUser("menu"));

		addOrReplace(new ListView<Stop>("stops-list", stops) {
			@Override
			protected void populateItem(final ListItem<Stop> item) {
				final Stop stop = item.getModelObject();
				item.add(new Label("name", stop.getName()));
				changeColor(item);
				item.add(new AjaxEventBehavior("click") {
					@Override
					protected void onEvent(AjaxRequestTarget target) {
						setResponsePage(new StopScheduleForLoggedUser(stop));
					}
				});

			}

			private void changeColor(final ListItem<Stop> item) {
				if (item.getIndex() % 2 == 0) {
					item.add(AttributeModifier.append("style", "background:grey;"));
				} else {
					item.add(AttributeModifier.append("style", "background:black;"));

				}
			}
		});

	}

	public StopsForLoggedUser() {
		super();

	}

	public StopsForLoggedUser(Route route) {
		super(route);

	}
}
