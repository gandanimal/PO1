package sth.core;

public class Book extends Work{

private String _author;
private int _isbn;

public Book(String title, String author, int price, Category cat, int isbn, int numberOfCopies){
    super(title, price, numberOfCopies);
    _author = author;
    _isbn = isbn;
    
   }

}   