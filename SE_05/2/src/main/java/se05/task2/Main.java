package se05.task2;



public class Main {

	public static void main(String[] args) {
		PropertyFileReader propertiFileReader = new PropertyFileReader();
		
		propertiFileReader.readFile("Ap1p");
		
		propertiFileReader.readFile("App");
		
		System.out.println(propertiFileReader.getValue("keyq"));
		System.out.println(propertiFileReader.getValue("key"));
		System.out.println(propertiFileReader.getValue("key123"));
		
	}

}
