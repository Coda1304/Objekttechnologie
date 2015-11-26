package main.java.com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Manager {
  private final List<Command> commands = new ArrayList<Command>();

  public void run( Command command ) {
    command.execute();
    this.commands.add( command );
  }

  public void undo() {
    if ( commands.isEmpty() ) {
      throw new IllegalStateException( "no commands remaining" );
    }

    Command lastCommand = commands.remove( commands.size() - 1 );
    lastCommand.undo();
  }
}