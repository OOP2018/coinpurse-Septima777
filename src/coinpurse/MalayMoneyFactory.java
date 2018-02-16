package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {

	private double[] malayMoney = new double[] { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };

	@Override
	public Valuable createMoney(double value) {
		Valuable v = null;
		for (double d : malayMoney) {
			if (d == value) {
				if (d > 0 && d < 1){
					v = new Coin(value, "Sen");
				}
				else if(d >= 1){
					v = new BankNote(value, "Ringgit",nextSerialNumber++);
				}
				else {
					throw new IllegalArgumentException();
				}
			}
		}
		return v;
	}

}
