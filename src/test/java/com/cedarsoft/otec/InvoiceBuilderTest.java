package test.java.com.cedarsoft.otec;

import org.junit.*;

import main.java.com.cedarsoft.otec.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceBuilderTest {
  @Test
  public void testInvoiceBuilder() throws Exception {
    InvoiceHeaderFactory factory = new DefaultInvoiceHeaderFactory();

    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
    Receiver receiver = new Receiver( "daname", "daAddress" );
    invoiceBuilder.setHeader( factory.createHeader( receiver ) );
    invoiceBuilder.addLineItem( new LineItem( 2, "Item1", new Money( 101 ) ) );
    invoiceBuilder.addLineItem( new LineItem( 3, "Item2 reduced", new Money( 301 ) ) );

    {
      invoiceBuilder.setSalesTaxCalculator( new FlatSalesTaxCalculator( 0.10 ) );

      Invoice invoice = invoiceBuilder.build();
      assertEquals( 2, invoice.getLineItems().size() );
      assertEquals( 2 * 101 + 3 * 301, invoice.getNetSum().getCents() );
      assertEquals( ( 2 * 1.01 + 3 * 3.01 ) * 1.10, invoice.getGrossSum().asDouble(), 0.01 );
    }

    {
      invoiceBuilder.setSalesTaxCalculator( new ReducedSalesTaxCalculator( 0.10, 0.05 ) );

      Invoice invoice = invoiceBuilder.build();
      assertEquals( 2 * 1.01 * 1.10 + 3 * 3.01 * 1.05, invoice.getGrossSum().asDouble(), 0.01 );
    }
  }
}
