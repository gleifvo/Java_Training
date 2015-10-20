package se02.task3;

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
}
