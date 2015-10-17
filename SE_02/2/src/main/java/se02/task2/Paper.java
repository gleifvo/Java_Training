package se02.task2;

public class Paper extends Stationery {

	private int defaultPrice = 5;

	public Paper() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Paper(int price, int count) {
		setPrice(price);

		setCount(count);
	}

	public Paper(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

}
