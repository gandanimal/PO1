package app.works;

import pt.tecnico.po.ui.Command;
import core.LibraryManager;
// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.3.2. Display all works.
 */
public class DoDisplayWorks extends Command<LibraryManager> {
  String _output;
  /**
   * @param receiver
   */
  public DoDisplayWorks(LibraryManager receiver) {
    super(Label.SHOW_WORKS, receiver);
    _output = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _output = _receiver.getAllWorks(); //get User Print String
    _display.add(_output); //add it to display

    _display.display(); //display
  }
}
