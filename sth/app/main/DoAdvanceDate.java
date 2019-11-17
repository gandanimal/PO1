package sth.app.main;

import sth.core.LibraryManager;

import pt.tecnico.po.ui.Command;

import java.util.Scanner;

// FIXME import iother core concepts
// FIXME import ui concepts

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager> {

  private int _days;
  Scanner scan; //scanner to read from stdin
  private String command; //variable to save String read from stdin
  private boolean advanced; //variable to check if date has been advanced

  /**
   * @param receiver
   */
  public DoAdvanceDate(LibraryManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    scan = new Scanner(System.in); //initialize scanner
    _days = 0;
    advanced = false;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    Message.requestDaysToAdvance();

    do {
      command = scan.next(); //get next input
      try {
        _days = Integer.parseInt(command); //convert to integer
      } catch (Exception e) {
        System.out.println("Invalid input " + e + "\n" ); //if command is not integer catch error
      }
      if(_days >0){ //if number if days is positive
        _receiver.advanceDays(_days); //advance date
        advanced = true; //change boolean variable to leave cycle
      }
      else{ //if number of days isn't positive
        System.out.println("Invalid input " + "\n" + Message.requestDaysToAdvance());
      }
    }while(advanced);
    }

  }
  

