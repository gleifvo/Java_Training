package se02.task4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setStationeryList(new StarterPack().getStationeryList());

		System.out.println("Before sorting");
		consolePrint(employee.getStationeryList());

		System.out.println("Sorted by price");
		employee.getStationeryList().sort(new PriceComparator());
		consolePrint(employee.getStationeryList());

		System.out.println("Sorted by name");
		employee.getStationeryList().sort(new NameComparator());
		consolePrint(employee.getStationeryList());

		System.out.println("Sorted by price and name");
		employee.getStationeryList().sort(new PriceAndNameComparator());
		consolePrint(employee.getStationeryList());
	}

	public static void consolePrint(ArrayList<Stationery> list) {
		System.out.println();

		for (Stationery stationery : list)
			System.out.println(stationery.toString());

		System.out.println();
	}

}
