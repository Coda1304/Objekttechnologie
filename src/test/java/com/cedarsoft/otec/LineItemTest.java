package test.java.com.cedarsoft.otec;

import org.junit.*;

import main.java.com.cedarsoft.otec.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class LineItemTest {
  @Test
  public void testSum() throws Exception {
    assertEquals( 202, new LineItem( 2, "Item1", new Money( 101 ) ).getSum().getCents() );
  }
}
