package test.java.com.cedarsoft.otec;

import com.google.common.collect.ImmutableList;

import main.java.com.cedarsoft.otec.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class FlatSalesTaxCalculatorTest {
  @Test
  public void testName() throws Exception {
    InvoiceHeader header = new InvoiceHeader( 123, 33, new Receiver( "a", "b" ) );
    Invoice invoice = new Invoice( header, ImmutableList.of( new LineItem( 1, "asdf", new Money( 300 ) ) ), new FlatSalesTaxCalculator( 0.19 ) );

    assertEquals( 3.00 * 0.19, invoice.getSalesTax().asDouble(), 0.0001 );
  }
}
