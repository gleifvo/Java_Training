package com.epam.training.dataaccess.model;

import java.io.Serializable;

public class RouteToUser implements Serializable {

	private Long userId;

	private Long routeId;

	public RouteToUser() {
		super();

	}

	public RouteToUser(Long userId, Long routeId) {
		super();
		this.userId = userId;
		this.routeId = routeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "RoutetoUser [userId=" + userId + ", routeId=" + routeId + "]";
	}

}
