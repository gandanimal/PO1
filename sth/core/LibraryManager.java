package sth.core;

import sth.app.exception.NoSuchUserException;
import sth.app.exception.UserRegistrationFailedException;
import sth.core.exception.BadEntrySpecificationException;
import sth.core.exception.ImportFileException;
import sth.core.exception.MissingFileAssociationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// FIXME import other system types
// FIXME import other project (core) types

/**
 * The façade class.
 */
public class LibraryManager {

  private Library _library;  // FIXME initialize this attribute
  private String _filename;
  private String _file;
  private boolean _modified = true;
  private List<User> _users = new ArrayList<User>();
  private Date _date;
  // FIXME define other attributes

  // FIXME define contructor(s)
  public LibraryManager(){

    _date = new Date(0);
    _library = new Library("Lib");
  }
  // FIXME define methods




  /**
   * Serialize the persistent state of this application.
   * 
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         state has not been set yet.
   * @throws IOException if some error happen during the serialization of the persistent state

   */



  public void save() throws IOException {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(_file)));
    out.writeObject(_library);
    out.close();
    _modified = false;
  }

  /**
   * Serialize the persistent state of this application into the specified file.
   * 
   * @param filename the name of the target file
   *
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         is not a valid one.
   * @throws IOException if some error happen during the serialization of the persistent state
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    if(_modified) {
      _file = filename;
      save();
    }
  }

  /**
   * Recover the previously serialized persitent state of this application.
   * 
   * @param filename the name of the file containing the perssitente state to recover
   *
   * @throws IOException if there is a reading error while processing the file
   * @throws FileNotFoundException if the file does not exist
   * @throws ClassNotFoundException 
   */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
    Library libAux =(Library)ois.readObject();
    ois.close();
    _library = libAux;
    _file = filename;
           
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param file the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String file) throws ImportFileException {
    try {
      _library.importFile(file);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }
  public String getImportFile() throws ImportFileException {
    if(_file == null) {
      throw new ImportFileException();
    }
    return _file;
  }

  public int getCurrentDate(){
    return _date.getCurrentDate();
  }

  public String advanceDays(int nDays){
    if(nDays >0){
      _date.advanceDays(nDays);
      return null;
    }
    else{
      return "Numero de dias tem de ser positivo\n";
    }
  }
  public User getUser(int id) throws NoSuchUserException {
    _users = getUserList();
    for (User u : _users) {
      if (u.getId() == id) {
        return u;
      }
    }
    throw new NoSuchUserException(id);
  }

  public boolean checkUser(int id){
    _users = getUserList();
    for (User u : _users) {
      if (u.getId() == id) {
        return true;
      }
    }
    return false;
  }

  public List<User> getUserList(){
    return _library.getUserList();
  }

  public void registerUser(String userName, String email) throws UserRegistrationFailedException {
    User user = new User(userName, email, _library.getNextUserId()); //register user
    _library.newUser(user); //increment user ID and add user to the users list
  }

  public Library getLibrary(){
    return _library;
  }

  public String printUser(User u){
    return _library.printUser(u);
  }


  public String getAllUsers(){
    return _library.getAllUsers();
  }

}
