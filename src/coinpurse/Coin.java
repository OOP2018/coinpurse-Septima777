package coinpurse;


/**
 * Coins in the purse that show its value and currency.
 * @author Noppawan Kulchol
 *
 */
public class Coin extends Money{
	
	/** new currency of malaysia coin */
	private String newCurrency;
	
	/**
	 * Initialize value and currency of coins.
	 * @param value is value of each coins.
	 * @param currency is currency of each coins.
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}
	
	/**
	 * Initialize value and currency of coins.
	 * @param value is value of each coins.
	 * @param currency is currency of each coins.
	 * @param newCurrency is currency of Malaysia coin, Sen.
	 */
	public Coin(double value, String currency, String newCurrency) {
		super(value, currency);
		this.newCurrency = newCurrency;
	}

	/**
	 * toString return the value and currency of coins. In case of Malaysia,
	 * If value less than 1, currency will be Sen.
	 * @return the value and currency of coins.
	 */
	@Override
	public String toString() {
		if(value < 1){
			return getValue()*100 + "-" + newCurrency +" coin";
		}
		return getValue() + "-" + getCurrency() + " coin";
	}
	
	
	
}
