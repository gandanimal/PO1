package core;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Work{

private static final AtomicInteger count = new AtomicInteger(0);
private int _id;
private int _price;
private int _numberOfCopies;
private String _title;
private int _numberOfAvailableCopies;
private Category _category;

public Work(String title, int price, int numberOfCopies){
    _title = title;
    _price = price;
    _numberOfCopies = numberOfCopies;
    _numberOfAvailableCopies = numberOfCopies;
    _id = count.getAndIncrement();

   }

   public String getTitle(){
        return _title;
   }
   public int getPrice(){
        return _price;
   }

   public int getNumberOfCopies(){
        return _numberOfCopies;
   }

   public int getNumberOfAvailableCopies(){
        return _numberOfAvailableCopies;
   }

   public int getId(){
        return _id;
   }

    public String getCategoryToString(){
        if(_category == Category.FICTION){
            return "Ficção";
        }
        else if(_category == Category.REFERENCE){
            return "Referência";
        }
        else if(_category == Category.SCITECH){
            return "Técnica e Científica";
        }
        return null;
    }

}   