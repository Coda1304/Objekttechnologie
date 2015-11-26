package test.java.com.cedarsoft.otec;

import org.junit.*;

import main.java.com.cedarsoft.otec.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultHeaderFactoryTest {
  @Test
  public void testHeader() throws Exception {
    DefaultInvoiceHeaderFactory factory = new DefaultInvoiceHeaderFactory();

    Receiver receiver = new Receiver( "daName", "daAddress" );
    InvoiceHeader header = factory.createHeader( receiver );

    assertNotNull( header );
    assertEquals( receiver, header.getReceiver() );

    //Verify that the date is not older than 1000ms=1sec
    assertTrue( System.currentTimeMillis() - header.getDate() < 1000 );
    assertEquals( 1, header.getInvoiceId() );


    //2nd header with new invoice id
    assertEquals( 2, factory.createHeader( receiver ).getInvoiceId() );
    assertEquals( 3, factory.createHeader( receiver ).getInvoiceId() );
    assertEquals( 4, factory.createHeader( receiver ).getInvoiceId() );
  }
}
