package com.epam.training.webapp.page.metadata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.epam.training.dataaccess.model.Stop;

public class MetadataForStops implements Serializable {

	private Map<Stop, Map<Integer, List<Integer>>> stops;

	public Map<Stop, Map<Integer, List<Integer>>> getStops() {
		return stops;
	}

	public MetadataForStops(Map<Stop, Map<Integer, List<Integer>>> stops) {
		super();
		this.stops = stops;
	}

	@Override
	public String toString() {
		return "MetadataForStops [stops=" + stops + "]";
	}

	public Map<Integer, List<Integer>> getScheduleForStop(Stop stop) {
		return stops.get(stop);

	}

}