package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultInvoiceHeaderFactory implements InvoiceHeaderFactory {
  private int lastGivenInvoiceId;

  @Override
  public InvoiceHeader createHeader( Receiver receiver ) {
    int invoiceId = nextInvoiceId();
    return new InvoiceHeader( System.currentTimeMillis(), invoiceId, receiver );
  }

  private int nextInvoiceId() {
    lastGivenInvoiceId++;
    return lastGivenInvoiceId;
  }
}
