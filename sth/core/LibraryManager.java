package core;

import java.io.*;

import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;

// FIXME import other system types
// FIXME import other project (core) types

/**
 * The façade class.
 */
public class LibraryManager {

  private Library _library;  // FIXME initialize this attribute
  private String _filename;
  String _file;
  private boolean _modified = true;
  // FIXME define other attributes

  // FIXME define contructor(s)
  LibraryManager(Library lib){
    _library = new Library("Lib");
  }
  // FIXME define methods



  /**
   * Serialize the persistent state of this application.
   * 
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         state has not been set yet.
   * @throws IOException if some error happen during the serialization of the persistent state

   */
  public void save(String filename) throws IOException {
    if(_modified) {
      _file = filename;
      save();
    }
  }


  public void save() throws IOException {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(_file)));
    out.writeObject(_library);
    out.close();
    _modified = false;
  }

  /**
   * Serialize the persistent state of this application into the specified file.
   * 
   * @param filename the name of the target file
   *
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         is not a valid one.
   * @throws IOException if some error happen during the serialization of the persistent state
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    // FIXME implement method
  }

  /**
   * Recover the previously serialized persitent state of this application.
   * 
   * @param filename the name of the file containing the perssitente state to recover
   *
   * @throws IOException if there is a reading error while processing the file
   * @throws FileNotFoundException if the file does not exist
   * @throws ClassNotFoundException 
   */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    // FIXME implement method
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param file the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String file) throws ImportFileException {
    try {
      _library.importFile(file);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }
  public String getImportFile() throws ImportFileException {
    if(file == null) {
      throw new ImportFileException();
    }
    return file;
  }
}
