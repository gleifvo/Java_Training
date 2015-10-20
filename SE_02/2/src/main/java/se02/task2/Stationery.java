package se02.task2;

abstract public class Stationery {

	private int count;

	private int price;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Stationery(int count, int price) {
		this.count = count;
		this.price = price;
	}

	public Stationery() {
	}

}
