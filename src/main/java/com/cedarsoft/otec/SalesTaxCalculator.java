package main.java.com.cedarsoft.otec;

/**
 * Calculates the sales tax
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface SalesTaxCalculator {
  /**
   * Calculates the sales tax for a given net value
   *
   * @param invoice the invoice
   * @return the sales tax
   */
  Money calculate( Invoice invoice );
}
