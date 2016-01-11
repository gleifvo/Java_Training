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
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.RouteService;
import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.page.metadata.MetadataForStops;

public class StopsForAnonymUser extends AbstractPage {

	@Inject
	private RouteService routeService;

	private Route route;

	protected List<Stop> stops;

	public StopsForAnonymUser(Route route) {
		super();
		this.route = route;
		stops = routeService.getStops(route);

	}

	public StopsForAnonymUser() {
		super();

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));

		add(new ListView<Stop>("stops-list", stops) {
			@Override
			protected void populateItem(final ListItem<Stop> item) {
				final Stop stop = item.getModelObject();
				item.add(new Label("name", stop.getName()));
				changeColor(item);
				item.add(new AjaxEventBehavior("click") {
					@Override
					protected void onEvent(AjaxRequestTarget target) {
						setResponsePage(new StopScheduleForAnonymUser(stop));
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
}
