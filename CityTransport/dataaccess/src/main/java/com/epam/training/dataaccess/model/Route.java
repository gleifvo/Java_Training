package com.epam.training.dataaccess.model;

public class Route extends AbstractObject {

	private Integer Interval;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Interval == null) ? 0 : Interval.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Route other = (Route) obj;
		if (Interval == null) {
			if (other.Interval != null)
				return false;
		} else if (!Interval.equals(other.Interval))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
