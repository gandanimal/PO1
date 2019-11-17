package sth.app.main;

import sth.core.LibraryManager;
import pt.tecnico.po.ui.Command;

/**
 * 4.1.4. Command to open the requests menu.
 */
public class DoOpenRequestsMenu extends Command<LibraryManager> {

  /**
   * @param receiver
   */
  public DoOpenRequestsMenu(LibraryManager receiver) {
    super(Label.OPEN_REQUESTS_MENU, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    sth.app.requests.Menu menu = new sth.app.requests.Menu(_receiver);
    menu.open();
  }
}
