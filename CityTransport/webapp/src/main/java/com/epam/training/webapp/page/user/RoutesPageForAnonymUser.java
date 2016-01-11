package com.epam.training.webapp.page.user;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.services.RouteService;
import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.page.metadata.MetadataForStops;

public class RoutesPageForAnonymUser extends AbstractPage {

	public static MetaDataKey<MetadataForStops> SESSION_METADATA_ROUTE = new MetaDataKey<MetadataForStops>() {
	};
	@Inject
	protected RouteService routeService;

	protected List<Route> allRoutes;

	public RoutesPageForAnonymUser() {
		super();
		allRoutes = routeService.getAll();

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));

		add(new ListView<Route>("routes-list", allRoutes) {

			@Override
			protected void populateItem(final ListItem<Route> item) {
				final Route route = item.getModelObject();
				item.add(new Label("id", route.getId()));
				item.add(new Label("interval", route.getInterval()));

				changeColor(item);

				item.add(new AjaxEventBehavior("onclick") {
					@Override
					protected void onEvent(AjaxRequestTarget target) {

						Session.get().setMetaData(SESSION_METADATA_ROUTE,
								new MetadataForStops(routeService.getSchedule(route)));

						StopsForAnonymUser page = new StopsForAnonymUser(
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
