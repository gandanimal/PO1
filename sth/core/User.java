package m19.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User{

private int _id;
private boolean _isActive;
private String _name;
private String _email;
private  UserBehavior _ub;
private int _fine;
private List<String> _notifications = new ArrayList<>();
   private static final AtomicInteger count = new AtomicInteger(0);

public User(String name, String email){
   _name = name;
   _email = email;
   _id = count.getAndIncrement();
   _isActive = true;
   _ub = UserBehavior.NORMAL;
   _fine = 0;
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

   public int getFine(){
      return _fine;
   }
   public String getBehavior(){
      return _ub.name();
   }

   protected boolean isActive(){
      return _isActive;
   }
   public String isActiveToString(){
      if(_isActive){
         return "ACTIVO";
      }
      else{
         return "SUSPENSO";
      }
   }

   public void suspend(){
      _isActive = false;
   }

   public void unsuspend(){
      _isActive = true;
   }

   public void makeUserFaltoso(){
      _ub = UserBehavior.FALTOSO;
   }

   public void makeUserCumpridor(){
      _ub = UserBehavior.CUMPRIDOR;
   }

   public void makeUserNormal(){
      _ub = UserBehavior.NORMAL;
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