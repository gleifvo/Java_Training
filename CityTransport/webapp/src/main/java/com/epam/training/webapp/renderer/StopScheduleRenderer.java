package com.epam.training.webapp.renderer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StopScheduleRenderer implements Serializable {

	private List<Integer> minutesList;

	private Integer hour;

	public List<Integer> getMinutesList() {
		return minutesList;
	}

	public Integer getHour() {
		return hour;
	}

	public StopScheduleRenderer(Integer hour, List<Integer> minutesList) {
		super();
		this.minutesList = minutesList;
		this.hour = hour;
	}

	public String getMinutes() {
		StringBuilder minutes = new StringBuilder();

		for (Integer time : minutesList) {
			minutes.append(time + " ");
		}

		return minutes.toString();

	}

	public static List<StopScheduleRenderer> convertMapToList(
			Map<Integer, List<Integer>> scheduleMap) {

		List<StopScheduleRenderer> listSchedule = new ArrayList<>();

		for (Entry<Integer, List<Integer>> entry : scheduleMap.entrySet()) {
			listSchedule.add(new StopScheduleRenderer(entry.getKey(), entry.getValue()));
		}

		return listSchedule;
	}

}
