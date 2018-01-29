package coinpurse;

/**
 * Bank notes in the purse that show its value and currency.
 * @author Septima
 *
 */
public class BankNote implements Valuable{
	
	private String currency;
	private double value;
	private long serialNumber;
	private final long nextSerialNumber = 1000000;
	
	/**
	 * * Initialize value and currency of bank notes.
	 * @param value is value of each bank notes.
	 * @param currency is currency of each bank notes.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
	}
	
	/**
	 * Get the value of bank notes.
	 * @return value of bank notes.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of bank notes.
	 * @return currency of bank notes.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check value and currency of bank notes that it equals to the other or not.
	 * If they have the same value and same currency it return true.
	 * @return true if it equals and return false if it does not equals.
	 * @param banknotes that we have to check.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) arg;
		if (this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue())
			return true;
		return false;
	}

	/**
	 * toString return the value and currency of bank notes.
	 * @return the value and currency of bank notes.
	 */
	@Override
	public String toString() {
		return value + "-" + currency + " note [" + getSerial() + "]";
	}
	
	/**
	 * Get the serial number of bank note.
	 * @return the serial number of bank note.
	 */
	public long getSerial(){
		this.serialNumber++;
		return serialNumber;
	}

	/**
	 * Order bank note by value so that smaller value of bank note come first and ignore currency.
	 * @return ordered bank note value.
	 * @param the other bank note that we have to compare.
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
