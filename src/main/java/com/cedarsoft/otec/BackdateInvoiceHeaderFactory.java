package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BackdateInvoiceHeaderFactory implements InvoiceHeaderFactory {
  private int lastGivenInvoiceId;

  @Override
  public InvoiceHeader createHeader( Receiver receiver ) {
    int invoiceId = nextInvoiceId();
    return new InvoiceHeader( createDate(), invoiceId, receiver );
  }

  private static long createDate() {
    return System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10;
  }

  private int nextInvoiceId() {
    lastGivenInvoiceId++;
    return lastGivenInvoiceId;
  }
}
