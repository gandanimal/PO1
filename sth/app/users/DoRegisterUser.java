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
    scan = new Scanner(System.in);
    _name = "";
    _email = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    Message.requestUserName();
    command = scan.next();
    _name = command;
    Message.requestUserEMail();
    command = scan.next();
    _email = command;
    try{
      _receiver.registerUser(_name, _email);
      _id = _receiver.getLibrary().getNextUserId();
      Message.userRegistrationSuccessful(_id);
    }catch(UserRegistrationFailedException e){
      throw new UserRegistrationFailedException(_name, _email);
    }


  }

}
