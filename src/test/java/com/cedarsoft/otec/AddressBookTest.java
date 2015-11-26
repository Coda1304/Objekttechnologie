package test.java.com.cedarsoft.otec;

import org.junit.*;

import main.java.com.cedarsoft.otec.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class AddressBookTest {
  @Test
  public void testBasic() throws Exception {
    AddressBook addressBook = new AddressBook();

    try {
      addressBook.getEntry( 1 );
      fail( "Where is the Exception" );
    } catch ( IllegalArgumentException e ) {
      assertEquals( "No entry found for id <1>", e.getMessage() );
    }
  }

  @Test
  public void testCommands() {
    AddressBook addressBook = new AddressBook();
    Manager manager = new Manager();

    assertEquals( 0, addressBook.getSize() );

    manager.run( new AddReceiverCommand( 1, new Receiver( "a", "b" ), addressBook ) );
    manager.run( new AddReceiverCommand( 2, new Receiver( "c", "d" ), addressBook ) );
    assertEquals( 2, addressBook.getSize() );

    manager.run( new ChangeCommand( 2, new Receiver( "1", "2" ), addressBook ) );
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "1", addressBook.getEntry( 2 ).getName() );

    manager.run( new RemoveCommand( 1, addressBook ) );
    manager.run( new RemoveCommand( 2, addressBook ) );

    assertEquals( 0, addressBook.getSize() );


    manager.undo();
    assertEquals( 1, addressBook.getSize() );
    manager.undo();
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "1", addressBook.getEntry( 2 ).getName() );
    manager.undo();
    assertEquals( 2, addressBook.getSize() );
    assertEquals( "c", addressBook.getEntry( 2 ).getName() );
    manager.undo();
    assertEquals( 1, addressBook.getSize() );
    manager.undo();

    assertEquals( 0, addressBook.getSize() );
  }
}