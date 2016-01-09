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
import com.epam.training.services.DriverService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class DriversPage extends AbstractPage {

	@Inject
	private DriverService driverService;

	public DriversPage() {
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

		DriversDataProvider usersDataProvider = new DriversDataProvider();

		int quantityElementsInTable = 10;

		final DataView<Driver> dataView = new DataView<Driver>("drivers-list",
				usersDataProvider, quantityElementsInTable) {

			@Override
			protected void populateItem(Item<Driver> item) {

				final Driver driver = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("firstName"));
				item.add(new Label("lastName"));
				item.add(new Label("age"));

				item.add(new Link("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new DriverEditPage(driver));
					}
				});
				item.add(new Link("delete-link") {
					@Override
					public void onClick() {
						driverService.deleteDriver(driver.getId());
					}
				});

			}
		};

		webMarkupContainer.add(dataView);
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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortfName",
				"first_name", usersDataProvider) {
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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortlName",
				"last_name", usersDataProvider) {

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

		webMarkupContainer.add(new AjaxFallbackOrderByBorder<Object>("sortAge", "age",
				usersDataProvider) {

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

	private class DriversDataProvider extends SortableDataProvider<Driver, Object> {

		public DriversDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Driver> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return driverService.getAll(first, count, sort.getProperty().toString(),
					currentSort.toString()).iterator();
		}

		@Override
		public long size() {
			return driverService.getAll().size();

		}

		@Override
		public IModel<Driver> model(Driver object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}