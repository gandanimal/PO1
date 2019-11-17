package sth.core;

public abstract class Work{

private int _id;
private int _price;
private int _numberOfCopies;
private String _title;

public Work(String title, int price, int numberOfCopies){
    _title = title;
    _price = price;
    _numberOfCopies = numberOfCopies;
   }
    
}   