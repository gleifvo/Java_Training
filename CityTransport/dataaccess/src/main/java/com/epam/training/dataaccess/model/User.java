package com.epam.training.dataaccess.model;

import java.io.Serializable;

public class User extends AbstractObject implements Serializable {

	private String login;

	private String password;

	private Long userTypeId;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", userTypeId=" + userTypeId + "]";
	}

}
