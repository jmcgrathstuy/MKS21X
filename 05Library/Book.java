public class Book{

    private String author;
    private String title;
    private String ISBN;

    public Book(){}

    public Book(String authorIn, String titleIn, String ISBNIn){
	author = authorIn;
	title = titleIn;
	ISBN = ISBNIn;
    }

    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String authorIn){
	author = authorIn;
    }
    public void setTitle(String titleIn){
	title = titleIn;
    }
    public void setISBN(String ISBNIn){
	ISBN = ISBNIn;
    }

    public String toString(){
	String toReturn = "";
	toReturn += author + ", " + title + ", " + ISBN;
	return toReturn;
    }

    //public static void main(String[] args){
    //	Book yeet  = new Book("Yeetmaster", "The Art of the Yeet", "3785678165786578346");
    //	System.out.println(yeet.toString());
    //	yeet.setISBN("not a number");
    //	System.out.println(yeet.toString());
    //}

}
