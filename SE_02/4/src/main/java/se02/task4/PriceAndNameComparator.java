package se02.task4;

import java.util.Comparator;

public class PriceAndNameComparator implements Comparator<Stationery> {

	public int compare(Stationery o1, Stationery o2) {

		int result = o1.getPrice() - o2.getPrice();

		if (result != 0)
			return result;

		result = o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
		
		if(result != 0)
			return result;
		
		return 0;
	}

}
