package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import m19.core.exception.ImportFileException;
import m19.core.exception.MissingFileAssociationException;

import java.io.IOException;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {
  Input<String> _newFile;
  // FIXME define input fields

  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    _newFile = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    String file;
    try {
      file = _receiver.getImportFile();

    } catch( ImportFileException e) {
      _form.parse();
      file = _newFile.value();
    }

    try {
      _receiver.saveAs(file);
    } catch(IOException e)  {
      e.printStackTrace();
    }catch(MissingFileAssociationException e){
        e.printStackTrace();
    }
  }
}
