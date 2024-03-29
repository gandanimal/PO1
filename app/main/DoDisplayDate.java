package app.main;

import core.LibraryManager;

import pt.tecnico.po.ui.Command;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.2. Display the current date.
 */
public class DoDisplayDate extends Command<LibraryManager> {
  String _output;
  /**
   * @param receiver
   */
  public DoDisplayDate(LibraryManager receiver) {

    super(Label.DISPLAY_DATE, receiver);
    _output = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _output = Message.currentDate(_receiver.getCurrentDate());
    _display.add(_output);

    _display.display();
  }
  
}
