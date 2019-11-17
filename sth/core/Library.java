package sth.core;

import sth.core.exception.BadEntrySpecificationException;

import java.io.IOException;
import java.io.Serializable;

// FIXME import other system types
// FIXME import project (core) types if needed

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;
  private String _name;
  private int _nextWorkId;
  private int _nextUserId;
  private Parser _parser;
  private Date _date;

  public Library(String nome){
    _date = new Date(0);
    _nextUserId = 0;
    _nextWorkId = 0;
    _parser = new Parser(this);
    _name = nome;

  }
  // FIXME define attributes

  // FIXME define contructor(s)

  // FIXME define methods

  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
  }

}
