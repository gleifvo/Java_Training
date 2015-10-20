package se02.task4;

public class Pen extends Stationery {

	private int defaultPrice = 50;

	public Pen() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Pen(int count, int price) {
		super(count, price);
	}

	public Pen(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

}
