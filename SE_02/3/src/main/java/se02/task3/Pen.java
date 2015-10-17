package se02.task3;

public class Pen extends Stationery {

	private int defaultPrice = 50;

	public Pen() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Pen(int price, int count) {
		setPrice(price);

		setCount(count);
	}

	public Pen(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

}
