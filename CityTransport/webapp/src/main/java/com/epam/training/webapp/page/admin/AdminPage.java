package com.epam.training.webapp.page.admin;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.epam.training.dataaccess.model.User;
import com.epam.training.services.UserService;
import com.epam.training.webapp.component.MenuForLoggedUser;
import com.epam.training.webapp.component.PanelForLoggedUser;
import com.epam.training.webapp.page.AbstractPage;

public class AdminPage extends AbstractPage {
	
	
	@Inject
	private UserService userService;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new PanelForLoggedUser("menu-panel"));
		add(new MenuForLoggedUser("menu"));

		UsersDataProvider usersDataProvider = new UsersDataProvider();
		DataView<User> dataView = new DataView<User>("users-list", usersDataProvider,5) {
			@Override
			protected void populateItem(Item<User> item) {
				final User user = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("fName", user.getLogin()));

				item.add(new Link("edit-link") {
					@Override
					public void onClick() {
					
					}
				});

			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "id", usersDataProvider));
		add(new OrderByBorder<Object>("sortfName", "firstName", usersDataProvider));

		add(new PagingNavigator("paging", dataView));
	}

	private class UsersDataProvider extends SortableDataProvider<User, Object> {

		public UsersDataProvider() {
			super();
			setSort("firstName", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends User> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());


			// TODO sort in service
			return userService.getAll().iterator();
		}

		@Override
		public long size() {
			return userService.getAll().size();
		}

		@Override
		public IModel<User> model(User object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}