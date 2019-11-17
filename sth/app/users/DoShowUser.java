package sth.app.users;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.core.LibraryManager;
import sth.core.User;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {
  Input<Integer> _id;
  String _output;
  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    _output = "";
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {


    User u = _receiver.getUser(_id.value()); //get User from User ID
    _output = _receiver.printUser(u); //get User Print String
    _display.add(_output); //add it to display

    _display.display(); //display


  }

}
