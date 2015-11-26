package test.java.com.cedarsoft.otec;

import org.junit.*;

import main.java.com.cedarsoft.otec.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class MoneyTest {
  @Test
  public void testToDouble() throws Exception {
    Money money = new Money( 101 );
    assertEquals( 1.01, money.asDouble(), 0 );
  }

  @Test
  public void testAdd() throws Exception {
    Money money = new Money( 101 );
    assertEquals( 181, money.add( new Money( 80 ) ).getCents() );
    assertEquals( 102, money.add( new Money( 1 ) ).getCents() );
  }

  @Test
  public void testSubstract() throws Exception {
    Money money = new Money( 101 );
    assertEquals( 81, money.substract( new Money( 20 ) ).getCents() );
    assertEquals( 1, money.substract( new Money( 100 ) ).getCents() );
  }

  @Test
  public void testMultiply() throws Exception {
    Money money = new Money( 101 );
    assertEquals( 1010, money.multiply( 10 ).getCents() );
    assertEquals( 10, money.multiply( 0.1 ).getCents() );
  }
}
