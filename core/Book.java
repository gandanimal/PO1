package core;

public class Book extends Work {

private String _author;
private int _isbn;
private Category _category;

public Book(String title, String author, int price, Category cat, int isbn, int numberOfCopies){
    super(title, price, numberOfCopies);
    _author = author;
    _isbn = isbn;
    _category = cat;

    
   }

   public String getAuthor(){
        return _author;
   }

   public int getIsbn(){
        return _isbn;
   }

   public Category getCategory(){


    return _category;
   }



}   