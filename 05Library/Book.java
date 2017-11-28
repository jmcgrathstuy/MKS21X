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

    public getAuthor(){
	return author;
    }
    public getTitle(){
	return title;
    }
    public getISBN(){
	return ISBN;
    }

    public setAuthor(String authorIn){
	author = authorIn;
    }
    public setTitle(String titleIn){
	title = titleIn;
    }
    public setISBN(String ISBNIn){
	ISBN = ISBNIn;
    }

}
