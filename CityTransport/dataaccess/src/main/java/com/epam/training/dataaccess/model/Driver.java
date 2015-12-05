package com.epam.training.dataaccess.model;

public class Driver {

	private Long id;

	private String lastName;

	private String firstName;

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", lastNamne=" + lastName + ", firstName=" + firstName
				+ ", age=" + age + "]";
	}

}
