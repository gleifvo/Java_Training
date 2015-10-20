package se02.task4;

public class Paper extends Stationery {

	private int defaultPrice = 5;

	public Paper() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Paper(int count, int price) {
		super(count, price);
	}

	public Paper(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

}
