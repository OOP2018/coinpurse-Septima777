package coinpurse;
/**
 * One of money factory that can create Thai money. If value is greater than 
 * and equals 20, it be bank notes but if value is smaller than 20, it be coins.
 * @author Noppawan Kulchol
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/* arrays of Thai money */
	private double[] thaiCoins = new double[] {1, 2, 5, 10};
	private double[] thaiBanknotes = new double[] {20, 50, 100, 500, 1000 };
	/* Bank note serial number */
	protected long nextSerialNumber = 1000000;
	private static final String DEFALT_CURRENCY = "Baht";
	
	/**
	 * create money (coins or bank notes)
	 * @param value is Thai money value
	 * @return new value of Thai money
	 * @throws IllegalArgumentException when cannot create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable = null;
		if(value >= 1 && value < 20){
			for(double coins : thaiCoins){
				if(coins == value) valuable = new Coin(value, DEFALT_CURRENCY);
			}
		}else if (value >= 20 && value <= 1000 ) {
			for(double bankNotes : thaiBanknotes){
				if(bankNotes == value) valuable = new BankNote(value, DEFALT_CURRENCY, nextSerialNumber++);
			}
		}else {
			throw new IllegalArgumentException("Cannot create money!");
		}
		return valuable;
	}

}
