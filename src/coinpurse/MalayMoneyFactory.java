package coinpurse;
/**
 * One of money factory that can create Malaysia money. If value is greater than 
 * and equals 20, it be bank notes but if value is smaller than 20, it be coins.
 * @author Noppawan Kulchol
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/* arrays of Malaysia money */
	private double[] malayCoins = new double[] { 0.05, 0.10, 0.20, 0.50};
	private double[] malayBanknotes = new double[] {1, 2, 5, 10, 20, 50, 100};
	/* Bank note serial number */
	protected long nextSerialNumber = 1000000000;
	/** currency of money */
	private static final String DEFULT_CURRENCY = "Ringgit";
	private static final String SMALL_CURRENCY = "Sen";
	/**
	 * create money (coins or bank notes)
	 * @param value is Malaysia money value
	 * @return new value of Malaysia money
	 * @throws IllegalArgumentException when cannot create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable = null;
		if(value > 0 && value < 1){
			for(double coins: malayCoins){
				if(coins == value) valuable = new Coin(value, SMALL_CURRENCY);
			}
		}else if(value >= 1 && value <= 100){
			for(double bankNotes : malayBanknotes){
				if(bankNotes == value) valuable = new BankNote(value, DEFULT_CURRENCY, nextSerialNumber++);
			}
		}else {
			throw new IllegalArgumentException("Cannot create money!");
		}
		
		return valuable;
	}

}
