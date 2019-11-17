package sth.core;

public class Dvd extends Work{

private String _director;
private int _igac;

public Dvd(String title, String director, int price, Category cat, int igac, int numberOfCopies){
    
    super(title, price, numberOfCopies);
    _director = director;
    _igac = igac;
   }


    
}   