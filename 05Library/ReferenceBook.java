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


}