public class Cycles {

	public static void main(String[] args) {
	
		double  h = 0.1;
		
		double a = -10, b = 10;
		
		for(double i = a; i <= b;i += h){			
			System.out.format("F(%.2f) = %.2f %n",
					i,(Math.tan(2*i)-3));
		}
	}

}
