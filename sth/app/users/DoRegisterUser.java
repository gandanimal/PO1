package sth.app.users;

import sth.app.exception.UserRegistrationFailedException;
import sth.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

import java.util.Scanner;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {
  Scanner scan; //scanner to read from stdin
  private String command; //variable to save String read from stdin
  private String _name;
  private String _email;
  private int _id;

  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);
    scan = new Scanner(System.in); //initialize scanner
    command = "";
    _name = "";
    _email = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    Message.requestUserName(); //request name
    command = scan.next(); //read name from in
    _name = command; //save name
    Message.requestUserEMail(); //request email
    command = scan.next(); // read email from in
    _email = command; //save email
    try{
      _receiver.registerUser(_name, _email); //register user with given email and name
      _id = _receiver.getLibrary().getNextUserId(); //get ID that user was registered with (assigned automatically)
      Message.userRegistrationSuccessful(_id); //return success message
    }catch(UserRegistrationFailedException e){ //if register fails
      throw new UserRegistrationFailedException(_name, _email);
    }


  }

}
