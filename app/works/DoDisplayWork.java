package app.works;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import core.LibraryManager;
import core.Work;
// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {
  Input<Integer> _id;
  String _output;

  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    _output = "";

  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {

    _id = _form.addIntegerInput(Message.requestWorkId());
    Work w = _receiver.getWork(_id.value()); //get Work from Work ID
    _output = _receiver.printWork(w); //get Work Print String
    _display.add(_output); //add it to display

    _display.display(); //display
  }
  
}
