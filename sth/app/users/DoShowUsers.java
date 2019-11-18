package m19.app.users;

import pt.tecnico.po.ui.Command;
import m19.core.LibraryManager;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.4. Show all users.
 */
public class DoShowUsers extends Command<LibraryManager> {
  String _output;
  /**
   * @param receiver
   */
  public DoShowUsers(LibraryManager receiver) {
    super(Label.SHOW_USERS, receiver);
    _output = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _output = _receiver.getAllUsers(); //get User Print String
    _display.add(_output); //add it to display

    _display.display(); //display
  }
  
}
