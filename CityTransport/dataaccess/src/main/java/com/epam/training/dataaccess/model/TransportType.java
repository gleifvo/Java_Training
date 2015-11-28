package com.epam.training.dataaccess.model;

public class TransportType {

	private Long id;

	private String type;

	private Integer capacity;

	private Integer Speed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getMaxSpeed() {
		return Speed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.Speed = maxSpeed;
	}

	@Override
	public String toString() {
		return "TransportType [id=" + id + ", type=" + type + ", capacity=" + capacity
				+ ", Speed=" + Speed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Speed == null) ? 0 : Speed.hashCode());
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportType other = (TransportType) obj;
		if (Speed == null) {
			if (other.Speed != null)
				return false;
		} else if (!Speed.equals(other.Speed))
			return false;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
