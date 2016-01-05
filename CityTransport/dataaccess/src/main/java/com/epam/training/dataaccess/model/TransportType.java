package com.epam.training.dataaccess.model;

public class TransportType extends AbstractObject {

	private String transportType;

	private Integer capacity;

	private Integer maxSpeed;


	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer speed) {
		maxSpeed = speed;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "TransportType [id=" + id + ", transportType=" + transportType
				+ ", capacity=" + capacity + ", Speed=" + maxSpeed + "]";
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
		if (maxSpeed == null) {
			if (other.maxSpeed != null)
				return false;
		} else if (!maxSpeed.equals(other.maxSpeed))
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
		if (transportType == null) {
			if (other.transportType != null)
				return false;
		} else if (!transportType.equals(other.transportType))
			return false;
		return true;
	}
}
