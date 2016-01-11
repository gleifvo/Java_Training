package com.epam.training.webapp.page.user;

import java.util.List;
import java.util.Map;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.epam.training.dataaccess.model.Stop;
import com.epam.training.webapp.component.MenuForAnonymUser;
import com.epam.training.webapp.component.PanelForAnonymUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.renderer.StopScheduleRenderer;

public class StopScheduleForAnonymUser extends AbstractPage {

	protected Stop stop;

	public StopScheduleForAnonymUser(Stop stop) {
		super();
		this.stop = stop;

	}

	public StopScheduleForAnonymUser() {
		super();

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Map<Stop, Map<Integer, List<Integer>>> stops = Session.get()
				.getMetaData(RoutesPageForAnonymUser.SESSION_METADATA_ROUTE).getStops();

		Map<Integer, List<Integer>> scheduleForStop = stops.get(stop);

		add(new PanelForAnonymUser("menu-panel"));
		add(new MenuForAnonymUser("menu"));

		add(new ListView<StopScheduleRenderer>("schedule",
				StopScheduleRenderer.convertMapToList(scheduleForStop)) {
			@Override
			protected void populateItem(final ListItem<StopScheduleRenderer> item) {
				final StopScheduleRenderer stop = item.getModelObject();
				item.add(new Label("hour", stop.getHour()));
				item.add(new Label("minutes", stop.getMinutes()));
				changeColor(item);

			}

			private void changeColor(final ListItem<StopScheduleRenderer> item) {
				if (item.getIndex() % 2 == 0) {
					item.add(AttributeModifier.append("style", "background:grey;"));
				} else {
					item.add(AttributeModifier.append("style", "background:black;"));

				}
			}
		});

	}
}
