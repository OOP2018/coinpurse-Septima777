package coinpurse;

/**
 * Bank notes in the purse that show its value and currency.
 * @author Noppawan Kulchol
 *
 */
public class BankNote extends Money{
	
	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	/**
	 * * Initialize value and currency of bank notes.
	 * @param value is value of each bank notes.
	 * @param currency is currency of each bank notes.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	
	/**
	 * toString return the value and currency of bank notes.
	 * @return the value and currency of bank notes.
	 */
	@Override
	public String toString() {
		return getValue() + "-" + getCurrency() + " note [" + getSerial() + "]";
	}
	
	/**
	 * Get the serial number of bank note.
	 * @return the serial number of bank note.
	 */
	public long getSerial(){
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
