package se02.task4;

import java.util.ArrayList;

public class StarterPack{

	private ArrayList<Stationery> stationeryList = new ArrayList<Stationery>();

	public StarterPack() {
		fillingStarterPack();
	}

	private void fillingStarterPack() {
		stationeryList.add(new Paper(50));
		
		stationeryList.add(new Pen(75,3));
		
		stationeryList.add(new Stapler(1));
		
		stationeryList.add(new Ruler(1));
	}

	public ArrayList<Stationery> getStationeryList() {
		return stationeryList;
	}

	public void setStationeryList(ArrayList<Stationery> stationeryList) {
		this.stationeryList = stationeryList;
	}
	
	

}
