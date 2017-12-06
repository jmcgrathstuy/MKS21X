public class Barcode{
	
	private String bar;
	private String zip;
	private int checkDig;
	
	private String[] reps = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	
	public Barcode( String zip){
		this.zip = zip;
		checkDig = sumDigs(zip) % 10;
		bar = "|";
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
		return bar + " (" + zip + ")";
	}
	
	public int sumDigs(String num){
		int sum = 0;
		for( int stepper = 0; stepper < this.zip.length(); stepper++){
			sum += Integer.parseInt(zip.substring(stepper, stepper + 1));
		}
		return sum;
	}
	
	public static String toCode( String zipCode){
		String[] reps = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		String inBar = "|";
		int check;
		Barcode b = new Barcode("11111");
		check = b.sumDigs(zipCode) % 10;
		if( zipCode.length() != 5){
			throw new IllegalArgumentException();
		}
		for( int stepper = 0; stepper < zipCode.length(); stepper++){
			if( !Character.isDigit(zipCode.charAt(stepper))){
				throw new IllegalArgumentException();
			}
		}
		for( int stepper = 0; stepper < zipCode.length(); stepper++){
			inBar += reps[Integer.parseInt(zipCode.substring(stepper, stepper + 1))];
		}
		inBar += reps[check] + "|";
		return inBar;
	}
	
	public static String toZip(String code){
		String buildZip = "";
		String[] reps = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		Barcode b = new Barcode("11111");
		
		if( code.length() != 32){
			throw new IllegalArgumentException();
		}
		if( !code.substring(0, 1).equals("|") || !code.substring(31, 32).equals("|")){
			throw new IllegalArgumentException();
		}
		for( int stepper = 1; stepper <= code.length() - 6; stepper += 5){
			boolean checker = true;
			for( int stepperIn = 0; stepperIn < reps.length; stepperIn++){
				if( code.substring(stepper, stepper + 5).equals(reps[stepperIn])){
					checker = false;
				}
			}
			if( checker){
				throw new IllegalArgumentException();
			}
		}
		
		for( int stepper = 1; stepper < code.length() - 6; stepper += 5){
			for( int stepperIn = 0; stepperIn < reps.length; stepperIn++){
				if( code.substring(stepper, stepper + 5).equals(reps[stepperIn])){
					buildZip += ( "" + stepperIn);
				}
			}
		}
		return buildZip;
	}

	/*public static void main(String[] args){
		Barcode b = new Barcode("11111");
		System.out.println(b.getZip());
		System.out.println(b.getBar());
		System.out.println(b.getCheckDig());
		System.out.println(b.toString());
		System.out.println(toCode( "11953"));
		System.out.println(toZip( "|:::||:::|||:|:::|:|:::||::|:|:|"));
		System.out.println(toZip( "|:::||:::|||:|:::|:|:::||::::::|"));*/
	}


}