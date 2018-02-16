package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {

	private double[] thaiMoney = new double[] { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	@Override
	public Valuable createMoney(double value) {
		Valuable v = null;
		for (double d : thaiMoney) {
			if (d == value) {
				if (d < 1){
					v = new Coin(value, "Satang");
				}else if (d >= 1 && d < 20) {
					v = new Coin(value, "Baht");
				}
				else if(d >= 20){
					v = new BankNote(value, "Baht", nextSerialNumber++);
				}
				else{
					throw new IllegalArgumentException();
				}
			}
		}
		return v;
	}

}
