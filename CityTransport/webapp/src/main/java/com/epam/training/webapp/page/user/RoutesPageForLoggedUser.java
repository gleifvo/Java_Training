package com.epam.training.webapp.page.user;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.services.UserService;
import com.epam.training.webapp.app.CustomSession;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.metadata.MetadataForStops;
import com.googlecode.wicket.jquery.ui.markup.html.link.Link;

public class RoutesPageForLoggedUser extends RoutesPageForAnonymUser {

	@Inject
	private UserService userService;

	private Long currentUserid;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		currentUserid = CustomSession.get().getCurrentUserid();

		this.addOrReplace(new PanelForLoggedUser("menu-panel"));
		this.addOrReplace(new MenuForLoggedUser("menu"));

		addOrReplace(new ListView<Route>("routes-list", allRoutes) {

			@Override
			protected void populateItem(final ListItem<Route> item) {
				final Route route = item.getModelObject();
				item.add(new Label("id", route.getId()));
				item.add(new Label("interval", route.getInterval()));

				changeColor(item);

				item.add(new AjaxEventBehavior("onclick") {
					@Override
					protected void onEvent(AjaxRequestTarget target) {

						userService.addRoute(currentUserid, route.getId());

						Session.get().setMetaData(SESSION_METADATA_ROUTE,
								new MetadataForStops(routeService.getSchedule(route)));

						StopsForLoggedUser page = new StopsForLoggedUser(
								item.getModelObject());
						setResponsePage(page);

					}
				});

			}

			private void changeColor(final ListItem<Route> item) {
				if (item.getIndex() % 2 == 0) {
					item.add(AttributeModifier.append("style", "background:grey;"));
				} else {
					item.add(AttributeModifier.append("style", "background:black;"));

				}
			}
		});

	}
}
