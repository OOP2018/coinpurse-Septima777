package coinpurse;

/**
 * This abstract class is factory that can create money for Thai and Malaysia by
 * setFactory() and it is Singleton.
 * @author Noppawan Kulchol
 *
 */
public abstract class MoneyFactory {

	/** declare money factory */
	private static MoneyFactory instance;
	
	/**
	 * Get an instance of MoneyFactory instead of creating new instance of it.
	 * @return instance is new MoneyFactory
	 */
	public static MoneyFactory getInstance(){
		if(instance == null){
			instance = ReadFile.read();
		}
		return instance;		
	}
	
	/**
	 * create money (coins or bank notes)
	 * @param value is money value
	 * @return new value of money
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * create money (coins or bank notes)
	 * @param value is money value
	 * @return new value of money
	 */
	public Valuable createMoney(String value){
		double dValue = 0;
		try {
			dValue = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(value +" cannot be parsed as a double");
		}
		return createMoney(dValue);
	}
	
	/**
	 * set factory to be other money factory (such as set from 
	 * ThaiMoneyFactory to be MalayMoneyFactory).
	 * @param f
	 */
	public static void setFactory(MoneyFactory f){
		instance = f;
	}	

}
