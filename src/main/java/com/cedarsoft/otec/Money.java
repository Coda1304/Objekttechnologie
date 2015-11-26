package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Money {
  private final long cents;

  public Money( long cents ) {
    this.cents = cents;
  }

  public long getCents() {
    return cents;
  }

  public double asDouble() {
    return cents / 100.0;
  }

  public Money add( Money money ) {
    return new Money( getCents() + money.getCents() );
  }

  public Money substract( Money money ) {
    return new Money( getCents() - money.getCents() );
  }

  public Money multiply( double factor ) {
    return new Money( Math.round( getCents() * factor ) );
  }
}
