package se02.task4;

public class Ruler extends Stationery {

	private int defaultPrice = 250;

	public Ruler() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Ruler(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

	public Ruler(int count, int price) {
		super(count, price);
	}

	public int compareTo(Stationery o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
