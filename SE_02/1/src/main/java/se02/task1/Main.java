package se02.task1;

public class Main {

	public static void main(String[] args) {

		Pen pen = new Pen();

		Pen penTwo = new Pen(Ink.BLUE, PenMaterial.PLASTIC);

		System.out.println(pen.equals(penTwo));

		System.out.println(pen.hashCode() + " " + penTwo.hashCode());

		pen.setInk(Ink.GREEN);

		System.out.println(pen.hashCode() + " " + penTwo.hashCode());

		System.out.println(pen.toString());

	}

}
