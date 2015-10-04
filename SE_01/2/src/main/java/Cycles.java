public class Cycles {

	public static void main(String[] args) {
		int arraySize = 10;
		
		Cycles.CycleFor(arraySize);
		Cycles.CycleWhileDo(arraySize);
		Cycles.CycleDoWhile(arraySize);
	}
	private static void printArray(int [] array){
		for(int i = 0 ; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static void CycleFor(int size){
		int [] array = new int[size];
		
		for(int i = 0, value = 2; i < size; i ++,value +=2 ){
			array[i] = value;
			
			if((i + 1)%2 == 0)
				array[i] *= array[i-1];	
		}
		
		printArray(array);
	}
	
	private static void CycleWhileDo(int size){
		int [] array = new int[size];
		int i = 0,value = 2;
		
		while(i < size){
			array[i] = value;
			
			if((i+1)%2 == 0)
				array[i] *= array[i-1];
			
			i++;
			value +=2;
		}
		printArray(array);
	}
	
	private static void CycleDoWhile(int size){
		int [] array = new int[size];
		int i = 0,value = 2;
		
		do{
			array[i] = value;
			
			if((i+1)%2 == 0)
				array[i] *= array[i-1];
			
			i++;
			value +=2;
		}while(i<size);	
		printArray(array);
	}

}
