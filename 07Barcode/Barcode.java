public class Barcode{
	
	String bar;
	String zip;
	int checkDig;
	
	String[] reps = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	
	public Barcode( String zip){
		this.zip = zip;
		checkDig = sumDigs(zip) % 10;
		bar += "|";
		for( int stepper = 0; stepper < zip.length(); stepper++){
			bar += reps[Integer.parseInt(zip.substring(stepper, stepper + 1))];
		}
		bar += reps[checkDig] + "|";
	}
	
	
	public String getZip(){
		return zip;
	}
	public String getBar(){
		return bar;
	}
	public int getCheckDig(){
		return checkDig;
	}
	
	public String toString(){
		return "a";
	}
	
	public int sumDigs(String num){
		int sum = 0;
		for( int stepper = 0; stepper < zip.length(); stepper++){
			sum += Integer.parseInt(zip.substring(stepper, stepper + 1));
		}
		return sum;
	}



}