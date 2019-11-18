package sth.app.users;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.app.exception.UserRegistrationFailedException;
import sth.core.LibraryManager;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {
  private int _id;
  Input<String> _name;
  Input<String> _email;


  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);

  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {

    try{
      _name = _form.addStringInput(Message.requestUserName());
      _email = _form.addStringInput(Message.requestUserEMail());
      _id = _receiver.registerUser(_name.toString(), _email.toString()); //register user with given email and name, and get id value
      Message.userRegistrationSuccessful(_id); //return success message with given id
    }catch(UserRegistrationFailedException e){ //if register fails
      throw new UserRegistrationFailedException(_name.toString(), _email.toString());
    }


  }

}
