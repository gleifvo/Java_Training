package com.epam.training.dataaccess.model;

public class TransportToDriver {
	private Long transportId;

	private Long driverId;

	public Long getTransportId() {
		return transportId;
	}

	public void setTransportId(Long transportId) {
		this.transportId = transportId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "TransportToDriver [transportId=" + transportId + ", driverId=" + driverId
				+ "]";
	}

}
