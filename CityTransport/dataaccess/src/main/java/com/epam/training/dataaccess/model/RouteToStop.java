package com.epam.training.dataaccess.model;

public class RouteToStop {

	private Long routeId;

	private Long stopId;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getStopId() {
		return stopId;
	}

	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}

	@Override
	public String toString() {
		return "RouteToStop [routeId=" + routeId + ", stopId=" + stopId + "]";
	}

}
