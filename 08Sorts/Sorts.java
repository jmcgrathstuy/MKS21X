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
	
	
	/*public static void main( String[] agrs){
		int[] a = {43, 65, 90, 43, 56, 7, 1, 23, 5};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
		int[] b = {1, 1, 1, 1, 1, 1, 1};
		selectionSort(b);
		System.out.println(Arrays.toString(b));
		int[] c = {};
		selectionSort(c);
		System.out.println(Arrays.toString(c));
	}*/
	
}