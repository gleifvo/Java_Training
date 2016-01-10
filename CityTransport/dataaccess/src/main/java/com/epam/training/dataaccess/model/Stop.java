package com.epam.training.dataaccess.model;

import java.io.Serializable;

public class Stop extends AbstractObject implements Serializable {

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
