package test.java.com.cedarsoft.otec;

import com.google.common.collect.ImmutableList;

import main.java.com.cedarsoft.otec.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ReducedSalesTaxCalculatorTest {
  @Test
  public void testName() throws Exception {
    InvoiceHeader header = new InvoiceHeader( 123, 33, new Receiver( "a", "b" ) );
    Invoice invoice = new Invoice( header, ImmutableList.of( new LineItem( 1, "asdf", new Money( 300 ) ) ), new ReducedSalesTaxCalculator( 0.19, 0.07 ) );

    assertEquals( 3.00 * 0.19, invoice.getSalesTax().asDouble(), 0.0001 );
  }

  @Test
  public void testReduced() throws Exception {
    InvoiceHeader header = new InvoiceHeader( 123, 33, new Receiver( "a", "b" ) );
    Invoice invoice = new Invoice( header,
                                   ImmutableList.of(
                                     new LineItem( 1, "asdf", new Money( 300 ) )
                                     , new LineItem( 1, "asdf reduced", new Money( 500 ) )
                                   ),
                                   new ReducedSalesTaxCalculator( 0.19, 0.07 ) );

    assertEquals( 3.00 * 0.19 + 5.0 * 0.07, invoice.getSalesTax().asDouble(), 0.0001 );
  }
}
