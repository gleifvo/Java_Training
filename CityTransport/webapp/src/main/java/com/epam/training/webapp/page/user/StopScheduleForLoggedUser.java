package com.epam.training.webapp.page.user;

import java.util.List;
import java.util.Map;

import org.apache.wicket.Session;

import com.epam.training.dataaccess.model.Stop;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;

public class StopScheduleForLoggedUser extends StopScheduleForAnonymUser {

	public StopScheduleForLoggedUser() {
		super();

	}

	public StopScheduleForLoggedUser(Stop stop) {
		super(stop);

		this.stop = stop;
	}

	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.addOrReplace(new PanelForLoggedUser("menu-panel"));
		this.addOrReplace(new MenuForLoggedUser("menu"));

		Map<Stop, Map<Integer, List<Integer>>> stops = Session.get()
				.getMetaData(RoutesPageForLoggedUser.SESSION_METADATA_ROUTE).getStops();

		Map<Integer, List<Integer>> scheduleForStop = stops.get(stop);

	}
}
