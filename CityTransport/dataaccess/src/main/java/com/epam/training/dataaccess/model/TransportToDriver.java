package com.epam.training.dataaccess.model;

import java.io.Serializable;

public class TransportToDriver implements Serializable {
	private Long transportId;

	private Long driverId;

	public TransportToDriver() {
		super();

	}

	public TransportToDriver(Long transportId, Long driverId) {
		super();
		this.transportId = transportId;
		this.driverId = driverId;
	}

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
