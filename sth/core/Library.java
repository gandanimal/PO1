package sth.core;

import sth.core.exception.BadEntrySpecificationException;

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
  public void newUser(User u){
    _nextUserId++;
    _users.add(u); //add user to users list
  }
  protected String getAllUsers() {
    String output = "";
    List<User> _sortedList1 = new ArrayList<>(_users);
    _sortedList1.sort(UserComparator);
    for (User u : _sortedList1) {
      output += printUser(u);

    }
    return output;
  }
  public String printUser(User u){
    String printU = "";
    printU = u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - " + u.getBehavior()+ " - " + u.isActive(); //name + email + behavior + state
    if(u.isActive()) { //if user is active
      printU = printU + "\n";
      return printU; //return string as it is
    }
    else{ //if not
      printU = printU + " - EUR " + u.getFine() + "\n"; //add fine
      return printU; //return string with fine added
    }
  }
  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */

  protected static Comparator<User> UserComparator = new Comparator<User>(){ //compare Users by name
    public int compare(User u, User u1){
      if(u.getName().compareTo(u1.getName()) == 0){
        return u.getId() - u1.getId();
      }
      else{
        return u.getName().compareTo(u1.getName());
      }
    }
  };

  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    Parser p = new Parser(this);
    p.parseFile(filename);
  }

}
