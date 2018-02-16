package coinpurse;
/**
 * One of money factory that can create Malaysia money. If value is greater than 
 * and equals 20, it be bank notes but if value is smaller than 20, it be coins.
 * @author Noppawan Kulchol
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/* arrays of Malaysia money */
	private double[] malayMoney = new double[] { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
	/* Bank note serial number */
	protected long nextSerialNumber = 1000000000;
	
	/**
	 * create money (coins or bank notes)
	 * @param value is Malaysia money value
	 * @return new value of Malaysia money
	 * @throws IllegalArgumentException when cannot create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable v = null;
		for (double d : malayMoney) {
			if (d == value) {
				if (d > 0 && d < 1) v = new Coin(value, "Sen");				
				else if(d >= 1)	v = new BankNote(value, "Ringgit",nextSerialNumber++);
				else throw new IllegalArgumentException("Cannot create money.");
			}
		}
		return v;
	}

}
