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
  protected String getAllUsers(){
    String output = "";

    return output;
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
      return u.getName().compareTo(u1.getName());
    }
  };
  protected static Comparator<User> IdComparator = new Comparator<User>(){ //compare users by ID
    public int compare(User u, User u1){
      return u.getId() - u1.getId();
    }
  };
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
  }

}
