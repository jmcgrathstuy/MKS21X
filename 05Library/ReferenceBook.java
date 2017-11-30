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
		return super.toString() + ", " + this.getCollection();
	}
	
	/*public static void main(String[] args){
		ReferenceBook a = new ReferenceBook("me", "art of the yeet", "11223344", "90909090", "Best Yeets Volume 3");
		ReferenceBook z = new ReferenceBook("you", "art of the skrr", "44332211", "09090909", "Best Skrrs Volume 3");
		System.out.println(a.toString());
		System.out.println(a.getAuthor());
		a.checkout("Bob Dobalina", "When he wants to");
		System.out.println(a.circulationStatus());
		System.out.println(a.compareTo(z));
		System.out.println(z.compareTo(a));
		System.out.println(z.compareTo(z));
	}*/


}