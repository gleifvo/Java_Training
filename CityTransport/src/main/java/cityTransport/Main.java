package cityTransport;

public class Main {

	public static void main(String[] args) {
		CityTransportSytem cityTransportSytem = new CityTransportSytem();
		cityTransportSytem.getRoutes().add(new Route());
		cityTransportSytem.getRoutes().get(0).setId(0);
		cityTransportSytem.getRoutes().get(0).setInterval(17);
		
		Transport transport = new Tram();
		transport.setCapacity(150);
		transport.setMaxSpeed(60);
		transport.setRegistrationNumber(0001);
		

	}

}
