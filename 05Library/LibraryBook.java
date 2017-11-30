abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    String callNumber;

    public LibraryBook( String authorIn, String titleIn, String ISBNIn, String callNumberIn){
	    super(authorIn, titleIn, ISBNIn);
		callNumber = callNumberIn;
    }
	
	public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String callNumberIn){
	callNumber = callNumberIn;
    }
	
	abstract void checkout(String patron, String due);
	
	abstract void returned();
	
	abstract String circulationStatus();
	
	public int compareTo(LibraryBook b){
		if(this.getCallNumber < b.getCallNumber){
			return -1;
		}
		if(this.getCallNumber > b.getCallNumber){
			return 1;
		}
		return 0;
	}
	
	public String toString(){
		return super.toString() + ", " + this.getCallNumber;
	}
	

}