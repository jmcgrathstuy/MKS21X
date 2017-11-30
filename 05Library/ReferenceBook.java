public class ReferenceBook extends LibraryBook{
	
	String collection;
	
	public ReferenceBook( String authorIn, String titleIn, String ISBNIn, String callNumberIn, String collectionIn){
	    super(authorIn, titleIn, ISBNIn, callNumberIn);
		collection = collectionIn;
    }
	
	public String getCollection(){
	    return collection;
    }

    public void setCollection(String collectionIn){
	    collection = collectionIn;
    }
	
	public void checkout(String patron, String due){
		System.out.println("cannot check out a reference book");
	}
	
	public void returned(){
		System.out.println("reference  book could not have been checked out -- return impossible");
	}
	
	public String circulationStatus(){
		return "non-circulating reference book";
	}
	
	public String toString(){
		return super.toString() + ", " + this.getCollection;
	}


}