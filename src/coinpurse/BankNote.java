package coinpurse;

/**
 * Bank notes in the purse that show its value and currency.
 * @author Noppawan Kulchol
 *
 */
public class BankNote extends Money{
	
	private long serialNumber;
	
	/**
	 * * Initialize value and currency of bank notes.
	 * @param value is value of each bank notes.
	 * @param currency is currency of each bank notes.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
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
	

}
