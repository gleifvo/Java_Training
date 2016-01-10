package com.epam.training.dataaccess.model;

import java.io.Serializable;

public class RouteToStop implements Serializable {

	public RouteToStop(Long routeId, Long stopId) {
		super();
		this.routeId = routeId;
		this.stopId = stopId;
	}

	public RouteToStop() {
		super();

	}

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
