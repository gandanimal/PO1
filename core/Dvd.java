package core;

public class Dvd extends Work{

private String _director;
private int _igac;
private Category _category;

public Dvd(String title, String director, int price, Category cat, int igac, int numberOfCopies){
    
    super(title, price, numberOfCopies);
    _director = director;
    _igac = igac;
    _category = cat;
   }

   public String getDirector(){
        return _director;
   }

   public int getIgac(){
        return _igac;
   }

   public Category getCategory(){
        return _category;
   }


    
}   