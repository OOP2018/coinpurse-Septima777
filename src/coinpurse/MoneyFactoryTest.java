package coinpurse;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class use for test MoneyFactory.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyFactoryTest {

	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/** check setFactory() that it can set and get instance of Money factory */
	@Test 
	public void testSetAndGetInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}
	
	/** show that can create money for Thai and Malaysia both coins and bank notes */
	@Test (expected = IllegalArgumentException.class)
	 public void testCreateMoney() throws IllegalArgumentException{
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote1 = moneyFactory.createMoney(0);
		Valuable bankNote2 = moneyFactory.createMoney(1); 
		Valuable bankNote3 = moneyFactory.createMoney(20);
		Valuable bankNote4 = moneyFactory.createMoney(2000);
		assertEquals(bankNote1.getValue(), 0, TOL);
		assertEquals(bankNote2.getValue(), 1, TOL);
		assertEquals(bankNote3.getValue(), 20, TOL);
		assertEquals(bankNote4.getValue(), 2000, TOL);
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory moneyFactory2 = MoneyFactory.getInstance();
		Valuable bankNote5 = moneyFactory.createMoney(0);
		Valuable bankNote6 = moneyFactory2.createMoney(0.05); 
		Valuable bankNote7 = moneyFactory2.createMoney(100);
		Valuable bankNote8 = moneyFactory.createMoney(500);
		assertEquals(bankNote5.getValue(), 0, TOL);
		assertEquals(bankNote6.getValue(), 0.05, TOL);
		assertEquals(bankNote7.getValue(), 100, TOL);
		assertEquals(bankNote8.getValue(), 500, TOL);
	 }
	
	/** check serial number of Thai money and Malaysia bank notes */
	@Test
	public void testBankNoteSerialNumber() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote1 = moneyFactory.createMoney(20);
		Valuable bankNote2 = moneyFactory.createMoney(100);
		Valuable bankNote3 = moneyFactory.createMoney(500);
		assertEquals(((BankNote) bankNote1).getSerial(), 1000000);
		assertEquals(((BankNote) bankNote2).getSerial(), 1000001);
		assertEquals(((BankNote) bankNote3).getSerial(), 1000002);

		MoneyFactory.setFactory(new MalayMoneyFactory());
		moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote4 = moneyFactory.createMoney(1);
		Valuable bankNote5 = moneyFactory.createMoney(2);
		Valuable bankNote6 = moneyFactory.createMoney(5);
		assertEquals(((BankNote) bankNote4).getSerial(), 1000000000);
		assertEquals(((BankNote) bankNote5).getSerial(), 1000000001);
		assertEquals(((BankNote) bankNote6).getSerial(), 1000000002);
	}

	
	
}
