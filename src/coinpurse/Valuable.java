package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Noppawan Kulchol
 *
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get the value of coins and bank notes.
	 * @return value of coins and bank notes.
	 */
	public double getValue();
	
	
	/**
	 * Get the currency of coins and bank notes.
	 * * @return currency of coins and bank notes.
	 */
	public String getCurrency();
	

}
