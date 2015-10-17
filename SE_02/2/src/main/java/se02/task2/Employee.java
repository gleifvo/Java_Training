package se02.task2;

import java.util.ArrayList;

public class Employee implements IAwareStationeryCost {

	private ArrayList<Stationery> stationeryList = new ArrayList<Stationery>();

	public int StationeryCost() {
		int cost = 0;

		for (Stationery stationery : stationeryList)
			cost += stationery.getPrice() * stationery.getCount();

		return cost;
	}

	public ArrayList<Stationery> getStationeryList() {
		return stationeryList;
	}

	public void setStationeryList(ArrayList<Stationery> stationeryList) {
		this.stationeryList = stationeryList;
	}

}
