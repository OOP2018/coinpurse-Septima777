package coinpurse;

/**
 * This class show using all methods in MoneyFactory and MoneyFactory is Singleton.
 * @author Noppawan Kulchol
 *
 */
public class MoneyFactoryDemo {
	public static void main(String[] args) {
		MoneyFactory.setFactory(new MalayMoneyFactory()); 
		MoneyFactory moneyFactory = MoneyFactory.getInstance(); // MoneyFactory is Singleton
		System.out.println(moneyFactory.createMoney(0.05)); //Test createMoney
		System.out.println(moneyFactory.createMoney(10));
		System.out.println(moneyFactory.createMoney(100));
		System.out.println("----------------------------------------------");
		MoneyFactory.setFactory(new ThaiMoneyFactory()); 
		MoneyFactory moneyFactory2 = MoneyFactory.getInstance(); // MoneyFactory is Singleton
		System.out.println(moneyFactory2.createMoney(1)); //Test createMoney
		System.out.println(moneyFactory2.createMoney(100));
		System.out.println(moneyFactory2.createMoney(500));
	}

}
