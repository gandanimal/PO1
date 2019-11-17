package sth.app.main;

import sth.core.LibraryManager;
import pt.tecnico.po.ui.Command;

/**
 * 4.1.4. Command to open the works menu.
 */
public class DoOpenWorksMenu extends Command<LibraryManager> {

  /**
   * @param receiver
   */
  public DoOpenWorksMenu(LibraryManager receiver) {
    super(Label.OPEN_WORKS_MENU, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    sth.app.works.Menu menu = new sth.app.works.Menu(_receiver);
    menu.open();
  }
  
}
