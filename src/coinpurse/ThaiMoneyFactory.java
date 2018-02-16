package coinpurse;
/**
 * One of money factory that can create Thai money. If value is greater than 
 * and equals 20, it be bank notes but if value is smaller than 20, it be coins.
 * @author Noppawan Kulchol
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/* arrays of Thai money */
	private double[] thaiMoney = new double[] {1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	/* Bank note serial number */
	protected long nextSerialNumber = 1000000;
	
	/**
	 * create money (coins or bank notes)
	 * @param value is Thai money value
	 * @return new value of Thai money
	 * @throws IllegalArgumentException when cannot create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable v = null;
		for (double d : thaiMoney) {
			if (d == value){ 
				if (d >= 1 && d < 20) v = new Coin(value, "Baht");
				else if(d >= 20) v = new BankNote(value, "Baht", nextSerialNumber++);				
				else throw new IllegalArgumentException("Cannot create money.");				
			}
		}
		return v;
	}

}
