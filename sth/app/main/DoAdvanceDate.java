package m19.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import m19.core.LibraryManager;

// FIXME import iother core concepts
// FIXME import ui concepts

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager> {

  Input<Integer> _days;


  /**
   * @param receiver
   */
  public DoAdvanceDate(LibraryManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    _days = _form.addIntegerInput(Message.requestDaysToAdvance()); //request number of days to advance

  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    String advance = _receiver.advanceDays(_days.value()); //advance date
    _display.add(advance); //add it to displau
    _display.display(); //display

    }

  }
  

