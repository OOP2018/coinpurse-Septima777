package coinpurse;

/**
 * This class provide value, currency, getValue(), getCurrency(), equals() and
 * compareTo() for subclass(Coin and Banknote).
 * 
 * @author Noppawan Kulchol
 *
 */
public class Money implements Valuable {

	protected String currency;
	protected double value;

	/**
	 * Initialize value and currency of money.
	 * @param value is value of money.
	 * @param currency is currency of money.
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of money.
	 * 
	 * @return value of money.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of money.
	 * 
	 * @return currency of money.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Order money by value and currency so that smaller value of money come first.
	 * @return ordered money value.
	 * @param the other money that we have to compare.
	 */	
	@Override
	public int compareTo(Valuable arg) {

		if (this.getCurrency().compareToIgnoreCase(arg.getCurrency()) == 0) {
			if (this.getValue() > arg.getValue()) {
				return 1;
			} else if (this.getValue() < arg.getValue()) {
				return -1;
			} else {
				return 0;
			}
		}
		return this.getCurrency().compareToIgnoreCase(arg.getCurrency());
	}

	/**
	 * Check value and currency of money that it equals to the other or not. If
	 * they have the same value and same currency it return true.
	 * 
	 * @return true if it equals and return false if it does not equals.
	 * @param money
	 *            that we have to check.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Money other = (Money) arg;
		if (this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue())
			return true;
		return false;
	}

}