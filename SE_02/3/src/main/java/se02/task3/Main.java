package se02.task3;

public class Main {

	public static void main(String[] args) {	

		Employee employee = new Employee();
		
		employee.setStationeryList(new StarterPack().getStationeryList());
		
		for(Stationery stationery : employee.getStationeryList())
			System.out.println(stationery.toString());
	}

}
