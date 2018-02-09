package coinpurse;


/**
 * Coins in the purse that show its value and currency.
 * @author Noppawan Kulchol
 *
 */
public class Coin extends Money{
	/**
	 * Initialize value and currency of coins.
	 * @param value is value of each coins.
	 * @param currency is currency of each coins.
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * toString return the value and currency of coins.
	 * @return the value and currency of coins.
	 */
	@Override
	public String toString() {
		return getValue() + "-" + getCurrency();
	}

	/**
	 * Order coins by value so that smaller value of coins come first and ignore currency.
	 * @return ordered coins value.
	 * @param the other coin that we have to compare.
	 */	
	@Override
	public int compareTo(Valuable o) {
		if (this.value < o.getValue()){
			return -1;
		}else if (this.value > o.getValue()){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	
	
	
}
