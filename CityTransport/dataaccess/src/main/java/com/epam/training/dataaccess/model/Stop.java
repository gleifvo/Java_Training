package com.epam.training.dataaccess.model;

public class Stop extends AbstractObject {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + "]";
	}

}
