package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class FlatSalesTaxCalculator implements SalesTaxCalculator {
  private final double percentage;

  public FlatSalesTaxCalculator( double percentage ) {
    this.percentage = percentage;
  }

  @Override
  public Money calculate( Invoice invoice ) {
    return invoice.getNetSum().multiply( percentage );
  }
}
