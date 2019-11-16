package m19.sth.app.main;

import m19.sth.core.LibraryManager;
import pt.tecnico.po.ui.Command;

/** 4.1. Main menu. */
public class Menu extends pt.tecnico.po.ui.Menu {

  /**
   * @param receiver
   */
  public Menu(LibraryManager receiver) {
    super(Label.TITLE, new Command<?>[] { //4.1
      new DoOpen(receiver), //
      new DoSave(receiver), //
      new DoDisplayDate(receiver), //
      new DoAdvanceDate(receiver), //
      new DoOpenUsersMenu(receiver), //
      new DoOpenWorksMenu(receiver), //
      new DoOpenRequestsMenu(receiver), //
    });
  }

}
