package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ReducedSalesTaxCalculator implements SalesTaxCalculator {
  private final double percentageNormal;
  private final double percentageReduced;

  public ReducedSalesTaxCalculator( double percentageNormal, double percentageReduced ) {
    this.percentageNormal = percentageNormal;
    this.percentageReduced = percentageReduced;
  }

  @Override
  public Money calculate( Invoice invoice ) {
    Money netNormal = new Money( 0 );
    Money netReduced = new Money( 0 );

    for ( LineItem lineItem : invoice.getLineItems() ) {
      if ( isReduced( lineItem ) ) {
        netReduced = netReduced.add( lineItem.getSum() );
      }else {
        netNormal = netNormal.add( lineItem.getSum() );
      }
    }

    return netNormal.multiply( percentageNormal )
      .add( netReduced.multiply( percentageReduced ) );
  }

  protected boolean isReduced( LineItem lineItem ) {
    return lineItem.getDescription().contains( "reduced" );
  }
}
