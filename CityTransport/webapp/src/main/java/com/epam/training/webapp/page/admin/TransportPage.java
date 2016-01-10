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

import com.epam.training.services.TransportService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;
import com.epam.training.webapp.renderer.TransportRenderer;

@AuthorizeInstantiation(value = { "admin" })
public class TransportPage extends AbstractPage {

	@Inject
	private TransportService transportService;

	public TransportPage() {
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

		TransportDataProvider usersDataProvider = new TransportDataProvider();

		int quantityElementsInTable = 10;

		final DataView<TransportRenderer> dataView = new DataView<TransportRenderer>(
				"transport-list", usersDataProvider, quantityElementsInTable) {

			@Override
			protected void populateItem(Item<TransportRenderer> item) {

				final TransportRenderer transport = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("registrationNumber"));
				item.add(new Label("type"));
				item.add(new Label("routeId"));

				item.add(new Link("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new TransportEditPage(transport));
					}
				});
				item.add(new Link("delete-link") {
					@Override
					public void onClick() {
						transportService.deleteByRegistrationNumber(
								transport.getRegistrationNumber());
					}
				});

			}
		};

		webMarkupContainer.add(dataView);

		webMarkupContainer.add(new Link<Void>("add-link") {

			@Override
			public void onClick() {
				setResponsePage(new TransportEditPage());
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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortRegNumber",
				"registration_number", usersDataProvider) {
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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortType",
				"type_id", usersDataProvider) {

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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortNumber",
				"route_id", usersDataProvider) {

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

	private class TransportDataProvider
			extends SortableDataProvider<TransportRenderer, Object> {

		public TransportDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends TransportRenderer> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return TransportRenderer
					.convert(transportService.getAll(first, count,
							sort.getProperty().toString(), currentSort.toString()))
					.iterator();
		}

		@Override
		public long size() {
			return transportService.getCountTransport();

		}

		@Override
		public IModel<TransportRenderer> model(TransportRenderer object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}