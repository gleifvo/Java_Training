package se02.task3;

public class Ruler extends Stationery{

	private int defaultPrice = 250;

	public Ruler() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Ruler(int price, int count) {
		setPrice(price);

		setCount(count);
	}

	public Ruler(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}
}
