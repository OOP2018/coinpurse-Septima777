package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Noppawan Kulchol
 *
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get the value of coins and banknotes.
	 */
	public double getValue();
	
	
	/**
	 * Get the currency of coins and banknotes.
	 */
	public String getCurrency();
	

}
