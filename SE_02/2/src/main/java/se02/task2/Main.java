package se02.task2;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee();

		Employee secondEmployee = new Employee();

		
		
		employee.getStationeryList().add(new Pen());

		employee.getStationeryList().add(new Pen(75, 2));

		employee.getStationeryList().add(new Paper(1000));
		
		
		
		secondEmployee.getStationeryList().add(new Paper(3,2000));
		
		secondEmployee.getStationeryList().add(new Pen(100,5));
		

		
		
		System.out.println(employee.StationeryCost());
		
		System.out.println(secondEmployee.StationeryCost());

	}

}
