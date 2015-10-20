package se02.task4;

import java.util.Comparator;

public class PriceComparator implements Comparator<Stationery> {

	public int compare(Stationery o1, Stationery o2) {

		int result = o1.getPrice() - o2.getPrice();

		return result;
	}
}
