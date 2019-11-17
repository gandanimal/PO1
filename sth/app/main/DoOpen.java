package sth.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.app.exception.FileOpenFailedException;
import sth.core.LibraryManager;

import java.io.FileNotFoundException;
import java.io.IOException;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  // FIXME define input fields if needed
  private Input<String> _fileName;
  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    _fileName = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
      _form.parse();
    _receiver.load(_fileName.value());
    } catch (FileNotFoundException e) {
      throw new FileOpenFailedException(_fileName.toString());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
