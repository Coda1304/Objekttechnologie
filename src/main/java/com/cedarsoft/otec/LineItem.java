package main.java.com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class LineItem {
  private final int amount;
  private final String description;
  private final Money price;

  public LineItem( int amount, String description, Money price ) {
    this.amount = amount;
    this.description = description;
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }

  public Money getPrice() {
    return price;
  }

  public Money getSum() {
    return price.multiply( amount );
  }
}
