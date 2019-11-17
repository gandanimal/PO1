package sth.app.users;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import sth.core.LibraryManager;
import sth.core.User;

import java.util.Scanner;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {
  Scanner scan; //scanner to read from stdin
  private String command; //variable to save String read from stdin
  private int _id;
  String _output;
  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    _id = 0;
    scan = new Scanner(System.in); //initialize scanner
    command = "";
    _output = "";
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    Message.requestUserId(); //request user ID
    command = scan.next(); //read from in
    try {
      _id = Integer.parseInt(command); //convert to integer

    } catch (Exception e) {
      System.out.println("Invalid input " + e + "\n" ); //if command is not integer catch error
    }
    User u = _receiver.getUser(_id); //get User from User ID

    _output = _receiver.printUser(u); //get User Print String
    _display.add(_output); //add it to display

    _display.display(); //display


  }

}
