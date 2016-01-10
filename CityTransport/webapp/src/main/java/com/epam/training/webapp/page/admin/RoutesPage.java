package com.epam.training.webapp.page.admin;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.sort.AjaxFallbackOrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.epam.training.dataaccess.model.Driver;
import com.epam.training.dataaccess.model.Route;
import com.epam.training.services.RouteService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class RoutesPage extends AbstractPage {

	@Inject
	private RouteService routeService;

	public RoutesPage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));

		final WebMarkupContainer webMarkupContainer = new WebMarkupContainer("table");
		webMarkupContainer.setOutputMarkupId(true);
		add(webMarkupContainer);

		RoutesDataProvider usersDataProvider = new RoutesDataProvider();

		int quantityElementsInTable = 10;

		final DataView<Route> dataView = new DataView<Route>("routes-list",
				usersDataProvider, quantityElementsInTable) {

			@Override
			protected void populateItem(Item<Route> item) {

				final Route route = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("interval"));

				item.add(new Link("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new RouteEditPage(route));
					}
				});
				item.add(new Link("delete-link") {
					@Override
					public void onClick() {
						routeService.deleteRouteByNumber(route.getId());
					}
				});

			}
		};

		webMarkupContainer.add(dataView);

		webMarkupContainer.add(new Link("add-link") {

			@Override
			public void onClick() {
				setResponsePage(new RouteEditPage());

			}

		});
		final AjaxPagingNavigator ajaxPagingNavigator = new AjaxPagingNavigator("paging",
				dataView);
		add(ajaxPagingNavigator);

		webMarkupContainer.add(
				new AjaxFallbackOrderByBorder<Object>("sortId", "id", usersDataProvider) {
					@Override
					protected void onSortChanged() {
						dataView.setCurrentPage(0);
					}

					@Override
					protected void onAjaxClick(AjaxRequestTarget target) {
						target.add(webMarkupContainer);
						target.add(ajaxPagingNavigator);

					}
				});

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortInterval",
				"interval", usersDataProvider) {
			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(0);
			}

			@Override
			protected void onAjaxClick(AjaxRequestTarget target) {
				target.add(webMarkupContainer);
				target.add(ajaxPagingNavigator);
			}
		});

	}

	private class RoutesDataProvider extends SortableDataProvider<Route, Object> {

		public RoutesDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Route> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return routeService.getAll(first, count, sort.getProperty().toString(),
					currentSort.toString()).iterator();
		}

		@Override
		public long size() {
			return routeService.getCountRoutes();

		}

		@Override
		public IModel<Route> model(Route object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}