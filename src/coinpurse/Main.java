package coinpurse;
 
/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Noppawan Kulchol
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
//        // 1. create a Purse
//    	Purse purse = new Purse(4);
//        // 2. create a ConsoleDialog with a reference to the Purse object
//    	ConsoleDialog ui = new ConsoleDialog(purse);
//        // 3. run the ConsoleDialog
//    	ui.run();
    	
    	// 4. run the moneyFactory
    	MoneyFactory.setFactory(new ThaiMoneyFactory());
    	MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(100);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney(5);
		System.out.println(m2.getCurrency());
		System.out.println(m2.toString());
//		Valuable m3 = factory.createMoney(1000);
//		System.out.println(m3.toString());
//		Valuable m5 = factory.createMoney(3000);
//		System.out.println(m5.toString());
//		Valuable m4 = factory.createMoney(1000);
//		System.out.println(m4.toString());

//		System.out.println(m.getValue() );
//		System.out.println((BankNote)m);
    }
}
