package se02.task4;

import java.util.Comparator;

public class NameComparator implements Comparator<Stationery> {

	public int compare(Stationery o1, Stationery o2) {

		int result = o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());

		return result;
	}
}
