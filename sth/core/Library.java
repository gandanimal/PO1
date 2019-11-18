package m19.core;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.BadEntrySpecificationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// FIXME import other system types
// FIXME import project (core) types if needed

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;
  private String _name;
  private int _nextWorkId;
  private int _nextUserId;
  private Parser _parser;
  private List<User> _users = new ArrayList<User>();
  private List<Work> _works = new ArrayList<>();



  public Library(String nome){

    _nextUserId = 0;
    _nextWorkId = 0;
    _parser = new Parser(this);
    _name = nome;

  }

  public int getNextUserId(){
    return _nextUserId;
  }

  public List<User> getUserList(){
    return _users;
  }

  public List<Work> getWorkList(){
    return _works;
  }

  public Work getWork(int id) throws NoSuchWorkException {
    for (Work w : _works) { //go through work list
      if (w.getId() == id) { //if id was found return work
        return w;
      }
    }
    throw new NoSuchWorkException(id); //if not found throw exception
  }
  public User getUser(int id) throws NoSuchUserException {
    for (User u : _users) {//go through user list
      if (u.getId() == id) {//if id was found return user
        return u;
      }
    }
    throw new NoSuchUserException(id);//if not found throw exception
  }

  public boolean checkUser(int id){ //check if user exists
    for (User u : _users) { //go through user list
      if (u.getId() == id) { //if id was found return true
        return true;
      }
    }
    return false;
  }
  public void newUser(User u){
    _users.add(u); //add user to users list
  }

  public void newWork(Work w){
    _works.add(w); //add work to work list
  }

  protected String getAllUsers() {
    String output = "";
    List<User> _sortedList1 = new ArrayList<>(_users); //create new arraylist to sort items
    _sortedList1.sort(UserComparator); //sort using comparator
    for (User u : _sortedList1) { //go through sorted list
      output += printUser(u); //add user line to output

    }
    return output;
  }
  public String printUser(User u){
    String printU = "";
    if(checkUser(u.getId())){ //if user exists
        printU = u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - " + u.getBehavior()+ " - " + u.isActiveToString(); //name + email + behavior + state
        if(u.isActive()) { //if user is active
          printU = printU + "\n";
        }
        else{ //if not
          printU = printU + " - EUR " + u.getFine() + "\n"; //add fine

        }
        return printU; //return string
    }
    return null;
  }

  public String printWork(Work w){ //print Work
    String printW = "";
    printW = w.getId() + " - " + w.getNumberOfAvailableCopies() + " de " + w.getNumberOfCopies(); //add general details
    if(w instanceof Dvd) { //if work is a DVD add dvd details
      printW = printW + " - DVD - " + w.getTitle() + " - " + w.getPrice() + " - " + ((Dvd) w).getCategoryToString() + " - " + ((Dvd) w).getDirector() + " - " + ((Dvd) w).getIgac() + "\n";
    }
    else if(w instanceof Book){ //if work is a  Book add book details
      printW = printW + " - Livro - " + w.getTitle() + " - " + w.getPrice() + " - " + ((Book) w).getCategoryToString() + " - " + ((Book) w).getAuthor() + " - " + ((Book) w).getIsbn() + "\n";
    }
    return printW; //return output
  }

  protected String getAllWorks(){
    String output = "";
    for (Work w : _works) { //got through work list
      output += printWork(w); //add each work to output
    }
    return output; //return output
  }
  public void checkUserStatus(){ //function to return times once date is updated
    for (User u : _users){
     //incomplete
    }
  }

  protected static Comparator<User> UserComparator = new Comparator<User>(){ //compare Users by name
    public int compare(User u, User u1){
      if(u.getName().compareTo(u1.getName()) == 0){ //if users have the same name
        return u.getId() - u1.getId(); //compare ID
      }
      else{
        return u.getName().compareTo(u1.getName()); //compare names
      }
    }
  };
  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   *
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    Parser p = new Parser(this); //create parse for this library
    p.parseFile(filename); //parse library
  }

}
