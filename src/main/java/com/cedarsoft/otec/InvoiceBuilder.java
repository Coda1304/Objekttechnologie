package main.java.com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceBuilder {
  private final List<LineItem> lineItems = new ArrayList<LineItem>();

  private InvoiceHeader header;

  private SalesTaxCalculator salesTaxCalculator;

  public void addLineItem( LineItem lineItem ) {
    this.lineItems.add( lineItem );
  }

  public InvoiceHeader getHeader() {
    return header;
  }
  
  public SalesTaxCalculator getSalesTaxCalculator() {
    return salesTaxCalculator;
  }

  public void setSalesTaxCalculator( SalesTaxCalculator salesTaxCalculator ) {
    this.salesTaxCalculator = salesTaxCalculator;
  }

  public void setHeader( InvoiceHeader header ) {
    this.header = header;
  }

  public Invoice build() {
    if ( header == null ) {
      throw new IllegalStateException( "No header set" );
    }

    if ( salesTaxCalculator == null ) {
      throw new IllegalStateException( "No sales tax calculator set" );
    }

    return new Invoice( header, lineItems, salesTaxCalculator );
  }
}
