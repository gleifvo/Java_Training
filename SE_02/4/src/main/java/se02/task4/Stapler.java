package se02.task4;

public class Stapler extends Stationery {
	private int defaultPrice = 1250;

	public Stapler() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Stapler(int count, int price) {
		super(count, price);
	}

	public Stapler(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}
}
