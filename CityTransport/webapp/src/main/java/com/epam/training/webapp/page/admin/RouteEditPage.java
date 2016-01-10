package com.epam.training.webapp.page.admin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;

import com.epam.training.dataaccess.model.Route;
import com.epam.training.dataaccess.model.Stop;
import com.epam.training.services.RouteService;
import com.epam.training.services.StopService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;
import com.googlecode.wicket.jquery.ui.form.palette.Palette;

@AuthorizeInstantiation(value = { "admin" })
public class RouteEditPage extends AbstractPage {

	private List<Stop> stopList = new ArrayList<Stop>();
	private List<Stop> selectedStops = new ArrayList<Stop>();

	@Inject
	private RouteService routeService;

	@Inject
	private StopService stopService;

	private Route route = new Route();

	private boolean isNew;

	public RouteEditPage() {
		this(new Route());
		isNew = true;
	}

	public RouteEditPage(Route route) {
		super();
		this.route = route;
		isNew = false;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));
		add(new FeedbackPanel("feedback"));

		Form<Route> form = new Form<>("form", new CompoundPropertyModel<>(route));
		add(form);

		form.add(new TextField<String>("interval"));

		IChoiceRenderer<Stop> renderer = new ChoiceRenderer<Stop>("name", "id");

		selectedStops = routeService.getStops(route);

		stopList = stopService.getAll();

		final Palette<Stop> palette = new Palette<Stop>("palette",
				new ListModel<Stop>(selectedStops), new CollectionModel<Stop>(stopList),
				renderer, 10, false);

		form.add(palette);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				if (isNew) {
					routeService.addRoute(route);
				} else {
					routeService.updateRoute(route);
				}

				stopList.removeAll(selectedStops);

				for (Stop stop : stopList) {
					routeService.deleteStop(route.getId(), stop.getId());
				}

				for (Stop stop : selectedStops) {
					routeService.addStop(route.getId(), stop.getId());
				}

				setResponsePage(new RoutesPage());

			}
		});

	}
}
