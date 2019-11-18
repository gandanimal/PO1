package app;

import static pt.tecnico.po.ui.Dialog.IO;

import core.LibraryManager;
import core.exception.ImportFileException;

/**
 * Main driver for the library management application.
 */
public class App {
  /**
   * @param args
   */
  public static void main(String[] args) {
    LibraryManager mgr = new LibraryManager();

    String datafile = System.getProperty("import"); //$NON-NLS-1$
    if (datafile != null) {
      try {
        mgr.importFile(datafile);
      } catch (ImportFileException e) {
        // no behavior described: just present the problem
        e.printStackTrace();
      }
    }

    try {
      app.main.Menu menu = new app.main.Menu(mgr);
      menu.open();
    } finally {
      IO.close();
    }

  }

}
