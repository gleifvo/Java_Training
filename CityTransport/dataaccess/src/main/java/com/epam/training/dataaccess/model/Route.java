package com.epam.training.dataaccess.model;

public class Route {

	private Long id;

	private Integer Interval;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getInterval() {
		return Interval;
	}

	public void setInterval(Integer interval) {
		Interval = interval;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", Interval=" + Interval + "]";
	}

}
