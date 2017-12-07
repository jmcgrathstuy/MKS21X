import java.util.Arrays;
public class Sorts{
	
	
	public static String name(){
		return "01.McGrath.James";
	}
	
	public static void selectionSort(int[] data){
		int lowest;
		for( int stepper = 0; stepper < data.length; stepper++){
			lowest = stepper;
			for( int stepperIn = stepper; stepperIn < data.length; stepperIn++){
				if( data[stepperIn] < data[lowest]){
					lowest = stepperIn;
				}
			}
			int temp = data[stepper];
			data[stepper] = data[lowest];
			data[lowest] = temp;
		}
	}
	
	public static void insertionSort(int[] data){
		for( int stepper = 1; stepper < data.length && data.length > 1; stepper++){
			int keepUp = stepper;
			for( int stepperIn = stepper - 1; stepperIn >= 0; stepperIn--, keepUp--){
				if( data[keepUp] < data[stepperIn]){
				    int temp = data[keepUp];
				    data[keepUp] = data[stepperIn];
				    data[stepperIn] = temp;
				}
			}
		}
	}
	
	/*public static void main( String[] agrs){
		int[] a = {43, 65, 90, 43, 56, 7, 1, 23, 5};
		insertionSort(a);
		System.out.println(Arrays.toString(a));
		int[] b = {1, 3, 1, 2, 1, 2, 1};
		insertionSort(b);
		System.out.println(Arrays.toString(b));
		int[] c = {};
		insertionSort(c);
		System.out.println(Arrays.toString(c));
	}*/
	
}