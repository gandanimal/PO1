package sth.core;

import java.util.ArrayList;
import java.util.List;

public class User{

private int _id;
private boolean _isActive;
private String _name;
private String _email;
   private List<String> _notifications = new ArrayList<>();

public User(String name, String email){
   _name = name;
   _email = email;

}
   public String getName(){
      return _name;
   }

   public int getId(){
      return _id;
   }

   public String getEmail() {
      return _email;
   }

   protected String getNotifications(){
      String not="";
      for(String n : _notifications){
         not+=n;
      }
      _notifications=new ArrayList<>();
      return not;
   }
    
}