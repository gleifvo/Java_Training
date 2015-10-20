package se02.task4;

abstract public class Stationery{

	private int count;

	private int price;

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [count=" + count + ", price=" + price + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Stationery(int count, int price) {
		this.count = count;
		this.price = price;
	}

	public Stationery() {
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
