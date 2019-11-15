package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import java.io.FileNotFoundException;
import java.io.IOException;
import pt.tecnico.po.ui.DialogException;
import m19.app.exception.FileOpenFailedException;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  // FIXME define input fields if needed

  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    // FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
      // FIXME implement command
    } catch (FileNotFoundException fnfe) {
      throw new FileOpenFailedException(fnfe);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
