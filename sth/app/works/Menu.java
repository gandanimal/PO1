package sth.app.works;

import sth.core.LibraryManager;
import pt.tecnico.po.ui.Command;

/** 4.3. Works menu. */
public class Menu extends pt.tecnico.po.ui.Menu {

  /**
   * @param receiver
   */
  public Menu(LibraryManager receiver) {
    super(Label.TITLE, new Command<?>[] { //
      new DoDisplayWork(receiver), //
      new DoDisplayWorks(receiver), //
      new DoPerformSearch(receiver), //
    });
  }

}
