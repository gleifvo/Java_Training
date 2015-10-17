package se02.task3;

public class Stapler extends Stationery{
	private int defaultPrice = 1250;

	public Stapler() {
		setPrice(defaultPrice);

		setCount(1);
	}

	public Stapler(int price, int count) {
		setPrice(price);

		setCount(count);
	}
	
	public Stapler(int count) {
		setPrice(defaultPrice);

		setCount(count);
	}

	
}
