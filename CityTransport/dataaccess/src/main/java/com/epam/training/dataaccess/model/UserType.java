package com.epam.training.dataaccess.model;

public class UserType extends AbstractObject {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserType [id=" + id + ", type=" + type + "]";
	}

}
